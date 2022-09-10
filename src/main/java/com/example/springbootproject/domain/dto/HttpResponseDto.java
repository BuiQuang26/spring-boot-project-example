package com.example.springbootproject.domain.dto;

import com.example.springbootproject.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseDto {
    private Date time;
    private Boolean success;
    private Integer status;
    private String message;
    private Object data;

    public HttpResponseDto(Boolean success, Integer status, String message, Object data) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
        this.time = new Timestamp(new Date().getTime());
    }
}
