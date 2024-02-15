package com.vims.departmentservice.controller;


import com.vims.departmentservice.dto.DepartmentRequest;
import com.vims.common.domain.dto.DepartmentResponse;
import com.vims.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @GetMapping("/public/departments")
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/public/departments/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping("/public/departments")
    public ResponseEntity<DepartmentResponse> createDepartment(@RequestBody DepartmentRequest department){
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }
}
