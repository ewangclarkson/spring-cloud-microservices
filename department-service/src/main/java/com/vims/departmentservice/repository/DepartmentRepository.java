package com.vims.departmentservice.repository;

import com.vims.departmentservice.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    Boolean existsByDepartmentName(String name);
}
