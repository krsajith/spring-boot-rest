package com.example.restservice.repo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Testjson {
    public static void main(String[] args) throws JsonProcessingException {
        var json = """
                {
                  "uuid": "dcd2bb7c-3a6c-4770-b907-992267e8740a",
                  "created_by": "charan",
                  "created_timestamp": "2023-03-16T11:39:03.760117",
                  "tenant_id": "d7408d31-d720-4173-b76e-0595ce2679b4",
                  "updated_by": "charan",
                  "updated_timestamp": "2023-03-16T11:39:03.760118",
                  "brokerage_fee": null,
                  "clearing_broker": "Ninja",
                  "clearing_broker_account": "1234",
                  "clearing_fee": null,
                  "commodity": "Cocoa",
                  "company": "APICAL (MALYASIAN) SDN. BHD.",
                  "counterparty": null,
                  "currency": "GBP",
                  "exchange": "ICE London",
                  "exchange_for": "Exchange Of Futures for Futures",
                  "execution_broker": "IndiaExecution",
                  "expired_status": null,
                  "expiry_date": "2023-03-29T18:30:00",
                  "expiry_month": "CH23",
                  "future_index": "ICE",
                  "lot": 7,
                  "lot_size": 10,
                  "netting_status": "Not Netted",
                  "profitcenter": "Regional_profitCenter",
                  "tag": null,
                  "trade_date": "2023-03-16T06:07:15.107",
                  "trade_id": "012731",
                  "trade_price": 1200,
                  "trade_transaction_type": 1,
                  "trade_type": "Exchange",
                  "trader_name": "charan",
                  "uom": "MT",
                  "cost": null,
                  "initial_margin": null,
                  "maintenance_margin": null,
                  "rollover_status": false,
                  "rollover_spread": null,
                  "parent_row_id": null,
                  "product_code": null,
                  "contract_month": "Mar 2023"
                }
                """;

        var om = new ObjectMapper();
        FutureTradeDTO futureTradeDTO=new FutureTradeDTO();;
        futureTradeDTO.setCreatedBy("Sajith");
        var x = om.readValue(json, FutureTradeDTO.class);

        System.out.println(om.writeValueAsString(x));

    }
}
