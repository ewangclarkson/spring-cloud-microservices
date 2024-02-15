package com.vims.employeeservice.domain.service;

import com.vims.common.domain.dto.DepartmentResponse;
import com.vims.employeeservice.client.DepartmentClient;
import com.vims.employeeservice.domain.model.Employee;
import com.vims.employeeservice.dto.EmployeeRequest;
import com.vims.employeeservice.dto.EmployeeResponse;
import com.vims.employeeservice.exceptions.EmployeeAlreadyExistException;
import com.vims.employeeservice.exceptions.EmployeeNotFoundException;
import com.vims.employeeservice.repository.EmployeeRepository;
import com.vims.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(String.format("The employee with id %d could not be found", id)));


        return mapToEmployeeResponse(employee, getDepartment(employee.getDepartmentId()));
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employee) {
        if (employeeRepository.existsByName(employee.getName())) {
            throw new EmployeeAlreadyExistException(String.format("The employee with name %s already exist in our system", employee.getName()));
        }

        return mapToEmployeeResponse(employeeRepository.save(Employee
                .builder()
                .name(employee.getName())
                .position(employee.getPosition())
                .departmentId(employee.getDepartmentId())
                .build()), getDepartment(employee.getDepartmentId()));
    }

    private EmployeeResponse.Department getDepartment(Long id){
        EmployeeResponse.Department department = new EmployeeResponse.Department();
        DepartmentResponse res = departmentClient.findById(id);
        department.setId(res.getId());
        department.setName(res.getName());
        return department;
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee, EmployeeResponse.Department department) {
        return EmployeeResponse
                .builder()
                .id(employee.getId())
                .name(employee.getName())
                .position(employee.getPosition())
                .department(department)
                .build();
    }
}
