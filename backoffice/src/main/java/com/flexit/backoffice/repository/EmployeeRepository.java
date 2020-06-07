package com.flexit.backoffice.repository;

import com.flexit.commons.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository <Employee, String> {

    /**
     * This method will retrieve the employee member list details by asc order
     */
    @Query()
    List<Employee> findAllByOrderByLastEventDateAsc();

    /**
     * This method will retrieve the employee member list details by desc order
     */
    @Query()
    List<Employee> findAllByOrderByLastEventDateDesc();
}