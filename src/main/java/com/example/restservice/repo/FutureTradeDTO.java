package com.example.restservice.repo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(SnakeToCamelNaming.class)
public class FutureTradeDTO extends AbstractBaseEntity {
    private UUID uuid;
    private String tradeId;
    private TradeTransactionType tradeTransactionType;
    private String tradeType = "";

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime tradeDate = LocalDateTime.now();
    private String company;
    private String profitcenter;
    private String traderName;
    private String futureIndex;
    private String commodity;
    private String exchange;
    private String expiryMonth;
    private Double lot;
    private Double matchLot;
    private Double balanceLot;
    private Double lotSize;
    private Double tradePrice;
    private String uom;
    private String currency;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime expiryDate;
    private String contractMonth;
    private String clearingBroker;
    private String clearingBrokerAccount;
    private String executionBroker;
    private Double brokerageFee;
    private Double clearingFee;
    private String exchangeFor;
    private String counterparty;
    private String nettingStatus;
    private String expiredStatus;
    private String tag;
    private String status;


    private Double cost;


    private Double maintenanceMargin;
    private Double initialMargin;
    private Boolean rolloverStatus = false;
    private Double rolloverSpread;
    private String productCode;
    private String parentRowId;

}
