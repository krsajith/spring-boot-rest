package com.example.restservice.dto.test;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class SnakeToCamelNaming extends PropertyNamingStrategies.SnakeCaseStrategy {
    private final PropertyNamingStrategies.LowerCamelCaseStrategy lowerCamelCaseStrategy = new PropertyNamingStrategies.LowerCamelCaseStrategy();
    @Override
    public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return  lowerCamelCaseStrategy.translate(defaultName);
    }

    @Override
    public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
        return translate(defaultName);
    }
}
