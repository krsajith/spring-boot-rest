package com.example.restservice.common;

import lombok.Getter;

@Getter
public class CustomError extends Exception {
    private final String errorCode;
    public CustomError(String errorCode) {
        super();
        this.errorCode = errorCode;
    }
}