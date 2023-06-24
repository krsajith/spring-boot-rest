package com.example.restservice;

import com.example.restservice.common.ModelMapperService;
import com.example.restservice.dto.PlannedObligationRepo;
import com.example.restservice.employee.Employee;
import com.example.restservice.employee.PlannedObligationsForActualization;
import com.example.restservice.repo.CustomRepoService;
import com.example.restservice.repo.EmployeeRepo;
import com.example.restservice.repo.FutureTradeInfoRepo;
import com.example.restservice.repo.PlannedObligationsForActualizationRepo;
import com.example.restservice.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class CustomRepositoryTests {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    PlannedObligationRepo getFutureTradeSummary;

    @Autowired
    private CustomRepoService customRepo;

    @Autowired
    private ModelMapperService modelMapperService;

    @Autowired
    private PlannedObligationsForActualizationRepo plannedObligationsForActualizationRepo;

    @Autowired
    private TestService testService;

    @Test
    void testFindAll() {
        assertFalse(employeeRepo.findAllEmployees(10).isEmpty());
    }

    @Test
    void testCustomRepo() {
//        List<Employee> employees = customRepo.findAllEmployees(10);
//        assertFalse(employees.isEmpty());
        customRepo.test(44);
    }

    @Test
    void testPlannedObligationsForActualization() {
        Specification<PlannedObligationsForActualization> spec = in("commodity", List.of("TEA"));
        var page = this.plannedObligationsForActualizationRepo.findAll(spec, Pageable.ofSize(10));
        log.debug("Page {}", page);
    }

    @Test
    @Transactional(readOnly = true)
    void tradeInfoFun() throws JsonProcessingException {
        var data = getFutureTradeSummary.getFutureTradeSummary("d7408d31-d720-4173-b76e-0595ce2679b4","537130");
        var om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.findAndRegisterModules();
        System.out.println(om.writeValueAsString(data));
        Assertions.assertNotNull(data);
    }


    private Specification<PlannedObligationsForActualization> in(String field, List<String> values) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lower(root.get(field)).in(values.stream().map(String::toLowerCase).toList());
    }

}
