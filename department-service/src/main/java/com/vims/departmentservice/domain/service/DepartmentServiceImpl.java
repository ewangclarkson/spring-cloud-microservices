package com.vims.departmentservice.domain.service;

import com.vims.departmentservice.domain.model.Department;
import com.vims.departmentservice.dto.DepartmentRequest;
import com.vims.departmentservice.dto.DepartmentResponse;
import com.vims.departmentservice.exceptions.DepartmentAlreadyExistException;
import com.vims.departmentservice.exceptions.DepartmentNotFoundException;
import com.vims.departmentservice.repository.DepartmentRepository;
import com.vims.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::mapToDeparmentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest department) {
        if (departmentRepository.existsByDepartmentName(department.getName())) {
            log.error(String.format("The department with name %s already exist", department.getName()));
            throw new DepartmentAlreadyExistException(String.format("The department with name %s already exist", department.getName()));
        }
        return mapToDeparmentResponse(departmentRepository.save(Department.builder().departmentName(department.getName()).build()));
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(String.format("The department with id %d could not be found", id)));

        return mapToDeparmentResponse(department);
    }

    private DepartmentResponse mapToDeparmentResponse(Department department) {
        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getDepartmentName())
                .build();
    }
}
