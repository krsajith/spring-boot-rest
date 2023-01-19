package com.example.restservice.event;

import com.example.restservice.employee.EmployeeDto;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public CustomEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishCustomEvent(CustomEvent<EmployeeDto> customEvent) {
        applicationEventPublisher.publishEvent(customEvent);
    }
}