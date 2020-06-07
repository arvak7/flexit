package com.flexit.commons.parser;

import com.flexit.commons.dto.EmployeeDTO;
import com.flexit.commons.entities.Employee;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ParserEmployee implements Parser<Employee, EmployeeDTO> {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public EmployeeDTO parse(Employee original) {
        EmployeeDTO employeeDTO = null;
        if (original != null) {
            employeeDTO = new EmployeeDTO();
            employeeDTO.setName(original.getName());
            employeeDTO.setLastEventDate(dateToString(original.getLastEventDate()));
        }
        return employeeDTO;
    }

    @Override
    public Employee unparse(EmployeeDTO original) {
        throw new UnsupportedOperationException("Not Implemented yet");
    }

    private String dateToString(Date date) {
        String newDate = null;
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            newDate = dateFormat.format(date);
        }
        return newDate;
    }
}
