package com.example.restservice.dto.test;

import com.example.restservice.dto.PlannedObligationState;
import com.example.restservice.repo.AbstractBaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class PlannedObligationv2Dto extends AbstractBaseEntity {

    //    private String String;
    private String broker;
    private Long circleStringSeq;
    private String commodity;
    private String company;
    private String counterparty;
    private String cropOrigin;
    private String deliveryDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliveryEndDate;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime deliveryStartDate;
    private String grade;
    private String incoterm;
    private String location;
    private String obligationDate;
    private String planId;
    private String planUuid;
    private String plannedObligationId;
    private Long plannedQuantity;
    private String priceType;
    private String profitcenter;
    private String quantityUOM;
    private String referenceNumber;
    private LocalDateTime tradeDateTime;
    private String tradeId;
    private String tradeObligationId;
    private String tradeObligationUuid;
    private Long tradePrice;
    private String tradePriceCurrency;
    private String tradePriceUom;
    private Long tradeQuantity;
    private Long tradeTransactionType;
    private String tradeType;
    private String tradeUuid;
    private Long noOfUnits;
    private String remarks;
    private String brand;
    private String season;
    private String loadLocation;
    private String unloadLocation;
    private String paymentTerm;
    private String trader;
    private Long fxRate;
    private Long provisionalFxRate;
    private String provisionalPricePercentage;
    private String provisionalPriceType;
    private String provisionalPrice;
    private String tradeSettlementCurrency;
    private Long premiunCost;
    private Long discountCost;
    private Long totalTradeQty;
    private String brokerReferenceNumber;
    private String provisionalPriceUom;
    private String provisionalPriceCurrency;
    private String plannedObligationStatus;
    private String parentPlannedObligation;
    private String shipmentMonth;
    private boolean externalRecord;
    private String deliveryTermClause;
    private String paymentTermsClause;
    private String quantityTermsClause;
    private String qualityTermsClause;
    private String pricingTermsClause;
    private String brokerReference;
    private String comments;
    private String docByPassId;
    private String tradeSettlementReference;
    @Type(JsonType.class)
    private List<ActualizeQuantityRow> actualizeQuantityRows;
    private String packageType;
    private String packageName;
    private String packageCapacity;
    private String packageUom;
    private String matchType;
    private String traderName;
    private String toleranceValue;
    private String quantityToleranceType;
    @Type(JsonType.class)
    private Map<PlannedObligationState,Boolean> obligationState= new HashMap<>();

    @Type(JsonType.class)
    private List<LcDetailsDTO> lcDetails;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlannedObligationv2Dto that = (PlannedObligationv2Dto) o;
        return getUuid() != null && Objects.equals(getUuid(), that.getUuid());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
