package com.vims.departmentservice.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {
    private Long id;
    private String name;
}
