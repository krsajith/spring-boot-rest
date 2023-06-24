package com.example.restservice.dto;

import com.example.restservice.dto.test.PlannedObligationv2Dto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;


public interface PlannedObligationRepo extends JpaRepository<PlannedObligationv2Dto, UUID> {
    @Query(
            value = "select (xtp).*,actualize_quantity_rows,package_type,package_name," +
                    "package_capacity,package_uom,match_type,trader_name,tolerance_value,quantity_tolerance_type,obligation_state,lc_details " +
                    "from get_transport_allocation_list_items(:tenantId,:vesselId)",
            nativeQuery = true)
    List<PlannedObligationv2Dto> getFutureTradeSummary(String tenantId,
                                                     String vesselId
    );
}
