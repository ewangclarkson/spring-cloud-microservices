package com.vims.departmentservice.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DepartmentRequest{
    @NotEmpty(message = "The department name is required")
    private String name;
}
