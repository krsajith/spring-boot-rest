package com.example.restservice.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Immutable;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Immutable
@Entity
@Table(name = "vw_planned_obligations_for_actualization")
public class PlannedObligationsForActualization {
    @Id
    private UUID uuid;
    private String createdBy;
    private String updatedBy;
    private OffsetDateTime createdTimestamp;
    private OffsetDateTime updatedTimestamp;
    private String tenantId;
    private Long circleStringSeq;
    private String company;
    private String plannedObligationId;
    private String tradeObligationId;
    private String planId;
    private String planUuid;
    private String tradeId;
    private String tradeUuid;
    private Long tradeTransactionType;
    private String tradeSettlementCurrency;
    private String trader;
    private OffsetDateTime tradeDateTime;
    private String commodity;
    private String counterparty;
    private Long tradeQuantity;
    private String profitCenter;
    private String incoterm;
    private String location;
    private String cropOrigin;
    private String quantityUom;
    private String grade;
    private String brand;
    private Double plannedQuantity;
    private OffsetDateTime deliveryStartDate;
    private OffsetDateTime deliveryEndDate;
    private String priceType;
    private Long tradePrice;
    private String tradePriceCurrency;
    private String tradePriceUom;
    private Long noOfUnits;
    private String loadLocation;
    private String unloadLocation;
    private String pricingStatus;
    private String provisionalPriceType;
    private String provisionalPrice;
    private String paymentTerm;
    private String provisionalPriceCurrency;
    private String provisionalPriceUom;
    private Long fxRate;
    private Long provisionalFxRate;
    private Long discountCost;
    private Long premiumCost;
    private Long totalTradeQty;
    private Double quantity;
    private String obligationState;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlannedObligationsForActualization that = (PlannedObligationsForActualization) o;
        return uuid != null && Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
