package com.flexit.commons.parser;

import com.flexit.commons.dto.EmployeeDTO;
import com.flexit.commons.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class ParserEmployee implements Parser<Employee, EmployeeDTO> {

    @Override
    public EmployeeDTO parse(Employee original) {
        EmployeeDTO employeeDTO = null;
        if (original != null) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setName(original.getName());
            employeeDTO.setLastEventDate(original.getLastEventDate());
        }
        return employeeDTO;
    }

    @Override
    public Employee unparse(EmployeeDTO original) {
        throw new UnsupportedOperationException("Not Implemented yet");
    }
}
