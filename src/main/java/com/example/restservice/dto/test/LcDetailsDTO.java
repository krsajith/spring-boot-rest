package com.example.restservice.dto.test;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LcDetailsDTO  {

    private String plannedObligationId;

    private LocalDateTime lcDate;

    private String lcNumber;

    private String lcBank;
}
