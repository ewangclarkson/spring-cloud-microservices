package com.vims.employeeservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequest {
    @NotEmpty(message = "user name must be entered")
    private String name;
    @NotNull(message = "department id must be valid")
    private Long departmentId;
    @NotEmpty(message = "THe position must be inputted")
    private String position;
}
