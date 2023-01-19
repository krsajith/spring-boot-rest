package com.example.restservice;

import com.example.restservice.common.ModelMapperService;
import com.example.restservice.common.CustomError;
import com.example.restservice.employee.Employee;
import com.example.restservice.employee.EmployeeDto;
import com.example.restservice.event.CustomEvent;
import com.example.restservice.event.CustomEventPublisher;
import com.example.restservice.event.EventType;
import com.example.restservice.repo.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final ModelMapperService modelMapperService;

    private final CustomEventPublisher eventPublisher;

    public EmployeeService(EmployeeRepo employeeRepo, ModelMapperService modelMapperService, CustomEventPublisher eventPublisher) {
        this.employeeRepo = employeeRepo;
        this.modelMapperService = modelMapperService;
        this.eventPublisher = eventPublisher;
    }

    public EmployeeDto save(EmployeeDto employeeDto) throws CustomError {
        if(employeeDto.getId()!=null &&  employeeRepo.findById(employeeDto.getId()).isEmpty()){
            throw new CustomError("ss-emp-0001");
        }
        var entity = employeeRepo.save(modelMapperService.map(employeeDto, Employee.class));
        var map = modelMapperService.map(entity, EmployeeDto.class);
        eventPublisher.publishCustomEvent(new CustomEvent<>(EventType.EMPLOYEE_CREATED, map));
        return map;
    }

    public List<Employee> getAllWithAge(Integer age) {
        return employeeRepo.findAllEmployees(age);
    }
}
