package com.example.restservice.repo;

import com.example.restservice.employee.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    @Query(value = "select * from get_all_employees(:age);", nativeQuery = true)
    List<Employee> findAllEmployees(@Param("age") Integer age);
}
