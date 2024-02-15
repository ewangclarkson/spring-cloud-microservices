package com.vims.departmentservice.exceptions;

public class DepartmentAlreadyExistException extends RuntimeException{
    public DepartmentAlreadyExistException(String message){
        super(message);
    }
}
