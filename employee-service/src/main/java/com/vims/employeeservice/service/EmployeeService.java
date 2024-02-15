package com.vims.employeeservice.service;

import com.vims.employeeservice.dto.EmployeeRequest;
import com.vims.employeeservice.dto.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse getEmployeeById(Long Id);
    EmployeeResponse createEmployee(EmployeeRequest employee);
}
