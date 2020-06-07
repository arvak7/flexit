package com.flexit.commons.parser;

import com.flexit.commons.dto.EmployeeDTO;
import com.flexit.commons.entities.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserEmployeeTest {

    private ParserEmployee parserEmployee;

    @BeforeEach
    void setup() {
        parserEmployee = new ParserEmployee();
    }

    @Test
    @DisplayName("parse a null Employee return a null EmployeeDTO")
    void testParseEmployeeIsNullThenReturnNull() {
        EmployeeDTO employeeDTO = parserEmployee.parse(null);
        assumeTrue(employeeDTO == null, "null Employee must return a null EmployeeDTO");
    }

    @Test
    @DisplayName("parse a Employee with info return EmployeeDTO with the same info")
    void testParseEmployeeIsWithInfoThenReturnTheSameInfo() {
        Employee original = createEmployee();
        EmployeeDTO employeeDTO = parserEmployee.parse(original);
        assumeTrue(employeeDTO != null, "a Employee with info must return a EmployeeDTO with info");
        assertEquals(employeeDTO.getName(), original.getName(), "must be the same name");
        assertEquals(employeeDTO.getLastEventDate().toInstant().toEpochMilli(), original.getLastEventDate().toInstant().toEpochMilli(), "must be the same date");
    }

    private Employee createEmployee() {
        Employee original = new Employee();
        original.setName("name");
        original.setLastEventDate(new Date());
        return original;
    }
}