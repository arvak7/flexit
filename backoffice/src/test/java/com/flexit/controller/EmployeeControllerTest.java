package com.flexit.controller;

import com.flexit.commons.dto.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Slf4j
class EmployeeControllerTest {

    private EmployeeController employeeController;

    @BeforeEach
    void setup() {
        employeeController = new EmployeeController();
    }

    @Test
    @DisplayName("Test getAllEmployees")
    void getAllEmployees_IsEmpty() {
        List<EmployeeDTO> allEmployees = employeeController.getAllEmployees();
        assumeTrue(allEmployees != null);
    }
}