package com.example.springbootproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseErrorDto {
    private Boolean success;
    private Integer status;
    private String errorCode;
    private String message;
    private Date time = new Date();

    public HttpResponseErrorDto(Boolean success, Integer status, String errorCode, String message) {
        this.success = success;
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
