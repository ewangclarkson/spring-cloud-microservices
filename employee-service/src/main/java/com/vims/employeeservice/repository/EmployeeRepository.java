package com.vims.employeeservice.repository;

import com.vims.employeeservice.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsByName(String name);
}
