package com.flexit.backoffice.service;

import com.flexit.backoffice.repository.EmployeeRepository;
import com.flexit.commons.dto.EmployeeDTO;
import com.flexit.commons.entities.Employee;
import com.flexit.commons.enums.Order;
import com.flexit.commons.parser.ParserEmployee;
import com.flexit.commons.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements GenericService<Employee, EmployeeDTO, Long> {

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private ParserEmployee parser;

    @Override
    public List<EmployeeDTO> findAll(Order order) {
        List<EmployeeDTO> employees = null;
        if (Order.ASC.equals(order)) {
            employees = repository.findAllByOrderByLastEventDateAsc().stream().map(employee -> parser.parse(employee)).collect(Collectors.toList());
        } else if (Order.DESC.equals(order)) {
            employees = repository.findAllByOrderByLastEventDateDesc().stream().map(employee -> parser.parse(employee)).collect(Collectors.toList());
        } else {
            employees = repository.findAll().stream().map(employee -> parser.parse(employee)).collect(Collectors.toList());
        }
        return employees;
    }

}