package com.flexit.backoffice.service;

import com.flexit.backoffice.controller.TestUtils;
import com.flexit.backoffice.repository.EmployeeRepository;
import com.flexit.commons.dto.EmployeeDTO;
import com.flexit.commons.enums.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.doReturn;

@Slf4j
@Disabled
@SpringBootTest
class EmployeeServiceImplTest extends TestUtils {

    @Autowired
    private EmployeeServiceImpl service;

    @MockBean
    private EmployeeRepository repository;

    public EmployeeServiceImplTest() throws ParseException {}

    @BeforeEach
    void setup() throws ParseException {
        doReturn(orderedEmployeeList).when(repository).findAllByOrderByLastEventDateAsc();
        doReturn(unorderedEmployeeList).when(repository).findAllByOrderByLastEventDateDesc();
    }

    @Test
    void testFindAllWithDescOrder() {
        List<EmployeeDTO> allEmployees = service.findAll(Order.DESC);
        assumeTrue(allEmployees != null, "Service not return all employees");
        List<EmployeeDTO> sortedEmployees = allEmployees.stream()
                .sorted(Comparator.comparingLong((EmployeeDTO e) -> stringDateToLong(e.getLastEventDate())).reversed()).collect(Collectors.toList());
        assertAll("Employees ordered",
                () -> assertEquals(sortedEmployees.get(0).getName(), allEmployees.get(0).getName(), "First employee is not ordered"),
                () -> assertEquals(sortedEmployees.get(sortedEmployees.size() - 1).getName(), allEmployees.get(allEmployees.size() - 1).getName(), "Last employee is not ordered")
        );
    }

    @Test
    void testFindAllWithAscOrder() {
        List<EmployeeDTO> allEmployees = service.findAll(Order.ASC);
        assumeTrue(allEmployees != null, "Service not return all employees");
        List<EmployeeDTO> sortedEmployees = allEmployees.stream()
                .sorted(Comparator.comparingLong((EmployeeDTO e) -> stringDateToLong(e.getLastEventDate()))).collect(Collectors.toList());
        assertAll("Employees ordered",
                () -> assertEquals(sortedEmployees.get(0).getName(), allEmployees.get(0).getName(), "First employee is not ordered"),
                () -> assertEquals(sortedEmployees.get(sortedEmployees.size() - 1).getName(), allEmployees.get(allEmployees.size() - 1).getName(), "Last employee is not ordered")
        );
    }
}