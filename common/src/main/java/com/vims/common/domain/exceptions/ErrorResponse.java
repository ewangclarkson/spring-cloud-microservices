package com.vims.common.domain.exceptions;


import lombok.Builder;

@Builder
public class ErrorResponse {
    String message;
    ErrorCode code;
    String endPoint;
}
