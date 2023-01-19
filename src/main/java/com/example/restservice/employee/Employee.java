package com.example.restservice.employee;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
//import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name ="sample_employee")
@Getter
@Setter
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private LocalDate dob;
    private String designation;
    private Date joiningDate;
}
