select *
from xceler_transportallocationservice_seafreightdetails xts
where xts.vessel_id = '537130'
  and xts.tenant_id = 'd7408d31-d720-4173-b76e-0595ce2679b4';

select *
from vw_planned_obligations_for_actualization_criteria;



select (xtp).*,
       actualize_quantity_rows,
       package_type,
       package_name,
       package_capacity,
       package_uom,
       match_type,
       trader_name,
       tolerance_value,
       quantity_tolerance_type,
       obligation_state
from get_transport_allocation_list_items('d7408d31-d720-4173-b76e-0595ce2679b4', '537130');

DROP FUNCTION get_transport_allocation_list_items(character varying, character varying);

CREATE or replace FUNCTION get_transport_allocation_list_items(p_tenant_id char varying, p_vessel_id char varying)
    RETURNS TABLE
            (
                xtp                     xceler_tradeplanningservice_plannedtradeobligation,
                actualize_quantity_rows jsonb,
                package_type            char varying,
                package_name            char varying,
                package_capacity        char varying,
                package_uom             char varying,
                match_type              char varying,
                trader_name             char varying,
                tolerance_value         char varying,
                quantity_tolerance_type char varying,
                obligation_state        jsonb,
                lc_details jsonb
            )
AS
$$
select xtp,
       xaa.actualize_quantity_rows,
       xpp.package_type,
       case
           when xpp.package_type = 'Container' then xpp.external_package
           when xpp.package_type = 'Unit' then xpp.internal_package end as package_name,
       case
           when xpp.package_type = 'Container' then xcc2.capacity
           when xpp.package_type = 'Unit' then xcc.capacity end         as package_capacity,
       case
           when xpp.package_type = 'Container' then xcc2.capacity_uom
           when xpp.package_type = 'Unit' then xcc.capacity_uom end     as package_uom,
       xtp2.match_type,
       xpp.trader_name,
       xpp.tolerance_value,
       xpp.quantity_tolerance_type,
       state.obligation_state,
       lcd.lc_details
from xceler_transportallocationservice_seafreightdetails xts
         inner join xceler_tradeplanningservice_plannedtradeobligation xtp
                    on xts.planned_obligation_ids ? xtp.planned_obligation_id
         inner join xceler_physicaltradeservice_physicaltrade xpp
                    on xpp.trade_id = xtp.trade_id and xpp.tenant_id = xtp.tenant_id
         left outer join xceler_tradeplanningservice_physicaltradeplan xtp2
                         on xtp2.tenant_id = xts.tenant_id and xtp2.planning_id = xtp.plan_id
         left outer join xceler_configservice_commoditypackage xcc
                         on xcc.tenant_id = xpp.tenant_id and xcc.name = xpp.commodity and
                            xcc.internal_package_name = xpp.internal_package
         left outer join xceler_configservice_commodityexternalpackage xcc2
                         on xcc2.tenant_id = xpp.tenant_id and xcc2.name = xpp.commodity and
                            xcc2.name = xpp.external_package
         left outer join get_actualized_quantities(xts.tenant_id, xts.planned_obligation_ids) xaa
                         on xaa.planned_obligation_id = xtp.planned_obligation_id
         left outer join get_planned_obligation_states(xts.tenant_id, xts.planned_obligation_ids) state
                         on state.planned_obligation_id = xtp.planned_obligation_id
         left outer join get_lc_details_for_planned_obligation_ids(xts.tenant_id, xts.planned_obligation_ids) lcd
                         on xaa.planned_obligation_id = xtp.planned_obligation_id
where xts.vessel_id = p_vessel_id
  and xts.tenant_id = p_tenant_id
  and xtp.tenant_id = xts.tenant_id;
$$ LANGUAGE SQL;

DROP FUNCTION get_actualized_quantities(character varying, jsonb);

CREATE or replace FUNCTION get_actualized_quantities(p_tenant_id char varying, p_planned_obligation_ids jsonb)
    RETURNS TABLE
            (
                planned_obligation_id   char varying,
                actualize_quantity_rows jsonb
            )
AS
$$
select id, coalesce(jsonb_agg(temp.*) FILTER (WHERE temp.planned_obligation_id IS NOT NULL), '[]'::jsonb)
from (select obs ->> 0                                                                          id,
             xaa.*,
             xcc.invoice_number != '' or invoice_status in ('Approved', 'Settled', 'POSTED') as final_invoiced
      from jsonb_array_elements(p_planned_obligation_ids) obs
               left outer join xceler_actualizationservice_actualizedquantity xaa on xaa.tenant_id = p_tenant_id
          and xaa.planned_obligation_id = obs ->> 0
               left outer join xceler_cashflowservice_cashflowdata xcc
                               on xaa.tenant_id = xcc.tenant_id and
                                  xaa.planned_obligation_id = xcc.planned_obligation_id
                                   and xaa.split_sequence_number = xcc.split_sequence_number and
                                  xaa.trade_id = xcc.trade_id
                                   and xcc.stage in ('Accrued', 'Invoice Final', 'Invoice Provisional')) temp
group by id
$$ LANGUAGE SQL;

select *
from get_actualized_quantities('d7408d31-d720-4173-b76e-0595ce2679b4',
                               '[
                                 "P/ENT321/23/008804",
                                 "P/ENT321/23/008823dd",
                                 "P/ENT321/23/008822",
                                 "P/ENT321/23/008826",
                                 "P/ENT321/23/008827",
                                 "P/ENT321/23/008829",
                                 "P/ENT321/23/008831",
                                 "P/ENT321/23/008830",
                                 "P/ENT321/23/008824",
                                 "P/ENT321/23/008832",
                                 "P/ENT321/23/008835",
                                 "P/ENT321/23/008836",
                                 "P/ENT321/23/008834",
                                 "P/ENT321/23/008825",
                                 "P/ENT321/23/008833",
                                 "P/ENT321/23/008828"
                               ]'::jsonb);

DROP FUNCTION get_lc_details_for_planned_obligation_ids(character varying, jsonb);

CREATE or replace FUNCTION get_lc_details_for_planned_obligation_ids(p_tenant_id char varying, p_planned_obligation_ids jsonb)
    RETURNS TABLE
            (
                planned_obligation_id char varying,
                lc_details            jsonb
            )
AS
$$
select obs, coalesce(jsonb_agg(xtl.*) FILTER (WHERE xtl.uuid IS NOT NULL), '[]'::jsonb)
from jsonb_array_elements(p_planned_obligation_ids) obs
         left outer join xceler_tradeplanningservice_lcdetails xtl
                         on xtl.tenant_id = p_tenant_id and xtl.planned_obligation_id = obs ->> 0
group by obs
$$ LANGUAGE SQL;

CREATE or replace FUNCTION get_planned_obligation_states(p_tenant_id char varying, p_planned_obligation_ids jsonb)
    RETURNS TABLE
            (
                planned_obligation_id char varying,
                obligation_state      jsonb
            )
AS
$$
select xtp.planned_obligation_id, jsonb_object_agg(xtp2.obligation_state, xtp2.status) as obligation_state
from xceler_tradeplanningservice_plannedtradeobligation xtp
         inner join jsonb_array_elements(p_planned_obligation_ids) obs
                    on xtp.planned_obligation_id = obs ->> 0 and xtp.tenant_id = p_tenant_id
         inner join xceler_tradeplanningservice_plannedtradeobligationstate xtp2 on xtp2.uuid = xtp.uuid
group by xtp.uuid, xtp.planned_obligation_id ;
$$ LANGUAGE SQL;

select *
from get_planned_obligation_states('d7408d31-d720-4173-b76e-0595ce2679b4', '[
  "P/96/23/10001sss4",
  "S/96/23/100015",
  "S/987654/23/101032"
]'::jsonb);

