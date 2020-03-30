package com.webbdealer.catalog.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
public class CustomErrorResponse {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private List<String> errors;

    public CustomErrorResponse(HttpStatus httpStatus, List<String> errors) {
        super();
        this.timestamp = LocalDateTime.now();
        this.status = httpStatus;
        this.errors = errors;
    }

    public CustomErrorResponse(HttpStatus httpStatus, String error) {
        super();
        this.timestamp = LocalDateTime.now();
        this.status = httpStatus;
        errors = Arrays.asList(error);
    }
}