package com.example.restservice.dto.test;

import com.example.restservice.repo.AbstractBaseEntity;
import com.example.restservice.repo.SnakeToCamelNaming;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@lombok.Data
@JsonNaming(SnakeToCamelNaming.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualizeQuantityRow  extends AbstractBaseEntity {
    private String Id;
    private String brand;
    private String grade;
    private String origin;
    private String purpose;
    private String tradeId;
    private String commodity;
    private String tenantId;
    private String createdBy;
    private String updatedBy;
    private String packageType;
    private String quantityUom;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime actualizedOn;
    private long loadQuantity;
    private boolean finalInvoiced;
    private long unloadQuantity;
    private String actualizationId;
    private long claimedQuantity;
    private String externalPackage;
    private String internalPackage;
    private long plannedQuantity;
    private String externalPackageUnit;
    private String internalPackageUnit;
    private String plannedObligationId;
    private long splitSequenceNumber;
    private String actualizedQuantityId;
    private long plannedObligationType;
    private String plannedExternalPackageUnit;
    private String plannedInternalPackageUnit;
}
