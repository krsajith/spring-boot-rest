package com.example.restservice.repo;

import com.example.restservice.dto.PlannedObligationDTO;
import com.example.restservice.employee.Employee;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

//import jakarta.persistence.EntityManager;
import jakarta.persistence.*;
//import javax.persistence.*;
import java.util.List;

@Service
public class CustomRepoService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    FutureTradeInfoRepo futureTradeInfoRepo;

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees(@Param("age") Integer age){
        var query = entityManager.createNativeQuery("select * from get_all_employees(:age);", Employee.class);
        query.setParameter("age",age);
        return query.getResultList();
    }

    public Object test(@Param("age") Integer age){

        return null;
    }
}


