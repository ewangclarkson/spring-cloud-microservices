package com.vims.departmentservice.service;

import com.vims.departmentservice.dto.DepartmentRequest;
import com.vims.common.domain.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
  List<DepartmentResponse> getAllDepartments();
  DepartmentResponse createDepartment(DepartmentRequest department);
  DepartmentResponse getDepartmentById(Long id);
}
