package com.flexit.commons.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EmployeeDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String lastEventDate;
}
