package com.example.restservice.event;

import com.example.restservice.employee.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Slf4j
public class CustomEventListener {
    @EventListener(condition = "#event.type.name eq 'EMPLOYEE_CREATED'")
    public void handleCreateEmployee(CustomEvent<? extends Serializable> event) {
        var employee = (EmployeeDto)event.payload();
        log.debug("Received spring custom event - {}, {}",event.type(),employee);
    }
}
