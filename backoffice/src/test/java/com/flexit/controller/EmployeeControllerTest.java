package com.flexit.controller;

import com.flexit.commons.dto.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeController employeeController;

    @BeforeEach
    void setup() {
        when(employeeController.getAllEmployees()).thenReturn(Arrays.asList(createEmployee("Pep", "1990-04-25"),
                createEmployee("Joana", "1990-04-24"), createEmployee("Laura", "1990-04-23")));
    }

    @Test
    @DisplayName("Test getAllEmployees")
    void getAllEmployees_haveSomeElements_ThenOrderDesc() {
        List<EmployeeDTO> allEmployees = employeeController.getAllEmployees();
        assumeTrue(allEmployees != null && allEmployees.size() > 1);
        List<EmployeeDTO> sortedEmployees = allEmployees.stream()
                .sorted(Comparator.comparingLong((EmployeeDTO e) -> stringDateToLong(e.getLastEventDate())).reversed()).collect(Collectors.toList());
        assertAll("Employees ordered",
                () -> assertEquals(sortedEmployees.get(0), allEmployees.get(0), "First employee is not ordered"),
                () -> assertEquals(sortedEmployees.get(sortedEmployees.size() - 1), allEmployees.get(allEmployees.size() - 1), "Last employee is not ordered")
        );
    }

    private Long stringDateToLong(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter).toEpochDay();
    }

    private EmployeeDTO createEmployee(String name, String date) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(name);
        employeeDTO.setLastEventDate(date);
        return employeeDTO;
    }
}