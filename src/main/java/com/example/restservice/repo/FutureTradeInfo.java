package com.example.restservice.repo;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;


@Data
@Entity
@Table(name="xceler_futuretradeservice_futuretrade_vw")
public class FutureTradeInfo extends AbstractBaseEntity {

    @Id
    private UUID uuid;

    private String commodity;
    private String futureindex;
    private Double lotsize;
    private Double totalLong;
    private Double totalShort;
    private String expiryMonth;

    @Type(JsonType.class)
    private List<FutureTradeDTO> futureTradesList;
}
