package com.flexit.backoffice.controller;

import com.flexit.commons.dto.EmployeeDTO;
import com.flexit.commons.entities.Employee;
import com.flexit.commons.enums.Order;
import com.flexit.commons.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeService")
    private GenericService<Employee, EmployeeDTO, Long> service;

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees() {
        return service.findAll(Order.DESC);
    }
}
