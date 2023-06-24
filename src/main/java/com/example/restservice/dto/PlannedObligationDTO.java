package com.example.restservice.dto;

import com.example.restservice.repo.AbstractBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class PlannedObligationDTO extends AbstractBaseEntity {

    private Integer circleStringSeq = 0;
    private Integer splitSequenceNumber = 0;
    private String referenceNumber;
    private String brokerReferenceNumber;
    private String company;
    private String plannedObligationId;
    private String tradeObligationId;
    private String tradeObligationUuid;
    private String planId;
    private String docByPassId;
    private String planUuid;
    private String tradeId;
    private String tradeUuid;
    private String tradeSettlementCurrency;
    private String tradeType;
    private String trader;
//    private Double matchQuantity;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime tradeDateTime;

    private String commodity;
    private String counterparty;
    private double tradeQuantity;

    private String profitcenter;
    private String incoterm;
    private String location;
    private String cropOrigin;
    private String quantityUOM;
    private String grade;
    private String brand;
    private double plannedQuantity;
    private double splitQuantity;
    @Type(JsonType.class)
    private Map<PlannedObligationState,Boolean> obligationState= new HashMap<>();

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliveryStartDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliveryEndDate;
    private String broker;
    private String priceType;
    private double tradePrice;
    private String tradePriceCurrency;
    private String tradePriceUom;
    private String matchType;

    private double noOfUnits;
    private String loadLocation;
    private String unloadLocation;
    private String packageType;
    private String packageName;
    private String packageUnit;
    private double packageCapacity;
    private String packageUom;

//    private double actualizedQuantity =0.0;
//    private double actualizedPackageUnit =0.0;
    @Type(JsonType.class)
    private List<ActualizedQuantityObligationsDTO> actualizeQuantityRows;
    public String pricingStatus;
    public String priceAllocationstatus;
//    private boolean finalInvoiced;
    private String remarks;
    private String season;
    private String provisionalPriceType;
    private Double provisionalPrice;
    private String paymentTerm;
    private String provisionalPriceCurrency;
    private String provisionalPriceUom;
    private Double fxRate;
    private Double provisionalFxRate;
    private String quantityToleranceType;
    private String toleranceValue;
    private Double provisionalPricePercentage;

    private double discountCost;

    private double premiunCost;

//    private Object commodityDetails;

    private Object paymentTerms;

//    private Object counterpartyDetails;

//    private Object companyDetails;

    private double totalTradeQty;

    private boolean externalRecord = false;


    private String deliveryTermClause;

//    private Object allocationInfo;

    private String paymentTermsClause;

    private String quantityTermsClause;

    private String qualityTermsClause;

    private String pricingTermsClause;

    private String brokerReference;

    private String comments;

//    private boolean linkedWithStock;
    private String tradeSettlementReference;

}
