package com.vims.common.domain.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ComponentScan(basePackages = {"com.vims.departmentservice.controller"})
@ControllerAdvice(basePackages ={"com.vims.employeeservice.controller"})
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFound(ResourceNotFoundException exp, HttpServletRequest req) {
        return ErrorResponse
                .builder()
                .code(ErrorCode.NOT_FOUND)
                .message(exp.getMessage())
                .endPoint(req.getRequestURI())
                .build();

    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleResourceAlreadyExist(ResourceAlreadyExistException exp, HttpServletRequest request) {
        return ErrorResponse
                .builder()
                .code(ErrorCode.ALREADY_EXIST)
                .message(exp.getMessage())
                .endPoint(request.getRequestURI())
                .build();
    }
}
