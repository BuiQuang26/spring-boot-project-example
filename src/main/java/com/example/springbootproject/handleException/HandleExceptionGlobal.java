package com.example.springbootproject.handleException;

import com.example.springbootproject.domain.dto.HttpResponseErrorDto;
import com.example.springbootproject.domain.exception.RoleNotFoundException;
import com.example.springbootproject.domain.exception.UserNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleExceptionGlobal {

    private final Logger logger = LogManager.getLogger(HandleExceptionGlobal.class);

    @ExceptionHandler(value = RoleNotFoundException.class)
    public ResponseEntity<?> handleException(RoleNotFoundException e){
        return new ResponseEntity<>(new HttpResponseErrorDto(false, 404, "ROLE_NOT_FOUND", "Role not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<?> handleException(UserNotFoundException e){
        return new ResponseEntity<>(new HttpResponseErrorDto(false, 404, "USER_NOT_FOUND", "User not found"), HttpStatus.NOT_FOUND);
    }
}
