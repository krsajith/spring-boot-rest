package com.example.restservice.service;

import com.example.restservice.dto.PlannedObligationDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    private final String sql = """
            select (xtp).*,
                   actualize_quantity_rows,
                   package_type,
                   package_name,
                   package_capacity,
                   package_uom,
                   match_type,
                   trader_name,
                   tolerance_value,
                   quantity_tolerance_type
            from get_transport_allocation_list_items(?,?);
            """;

    public TestService(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PlannedObligationDTO> getObligations(String tenantId, String vesselNumber) {
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PlannedObligationDTO.class), tenantId, vesselNumber);
    }
}
