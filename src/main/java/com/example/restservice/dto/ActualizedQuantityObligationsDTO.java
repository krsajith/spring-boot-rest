package com.example.restservice.dto;

public class ActualizedQuantityObligationsDTO {

    private String plannedObligationId;


    private String actualizedQuantityId;


    private String plannedObligationType;


    private Double plannedQuantity;


    private Double loadQuantity;


    private Double unloadQuantity;


    private String quantityUom;


    private String brand;


    private String grade;


    private String origin;


    private String commodity;

    private String tenantId;

    private String packageType;

    private String internalPackage;

    private String externalPackage;

    private Double internalPackageUnit;

    private Double externalPackageUnit;

    private Double plannedInternalPackageUnit;

    private Double plannedExternalPackageUnit;

    private String purpose;

    private Integer splitSequenceNumber = 0;

    private boolean finalInvoiced = false;

    private Double claimedQuantity = 0.0;

    public String getActualizedQuantityId() {
        return actualizedQuantityId;
    }

    public void setActualizedQuantityId(String actualizedQuantityId) {
        this.actualizedQuantityId = actualizedQuantityId;
    }

    public String getPlannedObligationType() {
        return plannedObligationType;
    }

    public void setPlannedObligationType(String plannedObligationType) {
        this.plannedObligationType = plannedObligationType;
    }

    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public void setPlannedQuantity(Double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public Double getLoadQuantity() {
        return loadQuantity;
    }

    public void setLoadQuantity(Double loadQuantity) {
        this.loadQuantity = loadQuantity;
    }

    public Double getUnloadQuantity() {
        return unloadQuantity;
    }

    public void setUnloadQuantity(Double unloadQuantity) {
        this.unloadQuantity = unloadQuantity;
    }

    public String getQuantityUom() {
        return quantityUom;
    }

    public void setQuantityUom(String quantityUom) {
        this.quantityUom = quantityUom;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getPlannedObligationId() {
        return plannedObligationId;
    }

    public void setPlannedObligationId(String plannedObligationId) {
        this.plannedObligationId = plannedObligationId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getInternalPackage() {
        return internalPackage;
    }

    public void setInternalPackage(String internalPackage) {
        this.internalPackage = internalPackage;
    }

    public String getExternalPackage() {
        return externalPackage;
    }

    public void setExternalPackage(String externalPackage) {
        this.externalPackage = externalPackage;
    }

    public Double getInternalPackageUnit() {
        return internalPackageUnit;
    }

    public void setInternalPackageUnit(Double internalPackageUnit) {
        this.internalPackageUnit = internalPackageUnit;
    }

    public Double getExternalPackageUnit() {
        return externalPackageUnit;
    }

    public void setExternalPackageUnit(Double externalPackageUnit) {
        this.externalPackageUnit = externalPackageUnit;
    }

    public Double getPlannedInternalPackageUnit() {
        return plannedInternalPackageUnit;
    }

    public void setPlannedInternalPackageUnit(Double plannedInternalPackageUnit) {
        this.plannedInternalPackageUnit = plannedInternalPackageUnit;
    }

    public Double getPlannedExternalPackageUnit() {
        return plannedExternalPackageUnit;
    }

    public void setPlannedExternalPackageUnit(Double plannedExternalPackageUnit) {
        this.plannedExternalPackageUnit = plannedExternalPackageUnit;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getSplitSequenceNumber() {
        return splitSequenceNumber;
    }

    public void setSplitSequenceNumber(Integer splitSequenceNumber) {
        this.splitSequenceNumber = splitSequenceNumber;
    }

    public boolean isFinalInvoiced() {
        return finalInvoiced;
    }

    public void setFinalInvoiced(boolean finalInvoiced) {
        this.finalInvoiced = finalInvoiced;
    }

    public Double getClaimedQuantity() {
        return claimedQuantity;
    }

    public void setClaimedQuantity(Double claimedQuantity) {
        this.claimedQuantity = claimedQuantity;
    }
}
