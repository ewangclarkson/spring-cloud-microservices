package com.vims.common.domain.exceptions;

public enum ErrorCode {
    NOT_FOUND("Resource not found"),
    ALREADY_EXIST("Resource Already Exist");

    private String message;

     ErrorCode(String message){
        this.message = message;
    }

    public String getMessage(){ return  message; }
}
