package com.vims.employeeservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeResponse {
    private Long id;
    private String name;
    private String position;
    private Department department;

    @Data
    public static class Department {
        private String name;
        private Long id;
    }
}
