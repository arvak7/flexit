package com.flexit.controller;

import com.flexit.commons.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    public List<EmployeeDTO> getAllEmployees() {
        return null;
    }

}
