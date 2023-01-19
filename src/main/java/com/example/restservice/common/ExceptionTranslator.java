package com.example.restservice.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Map;

@ControllerAdvice
public class ExceptionTranslator {
    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> handleError(
            CustomError ex,
            NativeWebRequest request
    ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("errorCode",ex.getErrorCode()));
    }
}
