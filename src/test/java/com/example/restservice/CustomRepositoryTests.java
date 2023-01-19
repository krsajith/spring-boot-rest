package com.example.restservice;

import com.example.restservice.common.ModelMapperService;
import com.example.restservice.employee.Employee;
import com.example.restservice.repo.CustomRepoService;
import com.example.restservice.repo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomRepositoryTests {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CustomRepoService customRepo;

    @Autowired
    private ModelMapperService modelMapperService;

    @Test
    void testFindAll() {
        assertFalse(employeeRepo.findAllEmployees(10).isEmpty());
    }

    @Test
    void testCustomRepo() {
        List<Employee> employees = customRepo.findAllEmployees(10);
        assertFalse(employees.isEmpty());
    }

}
