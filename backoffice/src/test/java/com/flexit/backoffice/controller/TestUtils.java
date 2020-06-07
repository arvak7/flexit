package com.flexit.backoffice.controller;

import com.flexit.commons.entities.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestUtils {

    public TestUtils() throws ParseException {}

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    protected List<Employee> orderedEmployeeList = Arrays.asList(createEmployee("Pep", "1990-10-14"),
            createEmployee("Joana", "1990-10-15"), createEmployee("Laura", "1990-10-16"));

    protected List<Employee> unorderedEmployeeList = Arrays.asList(createEmployee("Pep", "1990-10-16"),
            createEmployee("Joana", "1990-10-15"), createEmployee("Laura", "1990-10-14"));

    private Employee createEmployee(String name, String date) throws ParseException {
        Employee employeeDTO = new Employee();
        employeeDTO.setName(name);
        employeeDTO.setLastEventDate(stringToDate(date));
        return employeeDTO;
    }

    private Date stringToDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(date);
    }
}
