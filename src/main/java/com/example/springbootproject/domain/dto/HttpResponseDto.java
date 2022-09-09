package com.example.springbootproject.domain.dto;

import com.example.springbootproject.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseDto {
    private Boolean success;
    private Integer status;
    private String message;
    private Object data;
    private Date time = new Date();

    public HttpResponseDto(Boolean success, Integer status, String message, Object data) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
