package com.example.restservice.repo;

import com.example.restservice.employee.PlannedObligationsForActualization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PlannedObligationsForActualizationRepo extends JpaRepository<PlannedObligationsForActualization, UUID>, JpaSpecificationExecutor<PlannedObligationsForActualization>{
}
