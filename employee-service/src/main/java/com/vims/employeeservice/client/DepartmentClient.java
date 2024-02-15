package com.vims.employeeservice.client;

import com.vims.common.domain.dto.DepartmentResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface DepartmentClient {

    @GetExchange("/department-service/api/public/departments/{id}")
    DepartmentResponse findById(@PathVariable Long id);
}
