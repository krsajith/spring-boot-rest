package com.example.restservice.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDateTime;
import java.util.List;


public interface FutureTradeInfoRepo extends JpaRepository<FutureTradeInfo, Integer>, JpaSpecificationExecutor<FutureTradeInfo> {

    @Procedure(procedureName = "xceler_futuretradeservice_futuretrade_func")
    List<FutureTradeInfo> getFutureTradeSummary(String tenantId,
                                                String futureIndex,
                                                String executionBroker,
                                                String profitCenter,
                                                String expiryMonth,
                                                LocalDateTime fromDate,
                                                LocalDateTime toDate);
}
