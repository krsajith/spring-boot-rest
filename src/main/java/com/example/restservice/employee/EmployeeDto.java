package com.example.restservice.employee;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@ToString
public class EmployeeDto implements Serializable {
    private Long id;
    private String name;
    private LocalDate dob;
    private String designation;
}
