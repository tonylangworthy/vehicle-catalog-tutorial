package com.webbdealer.catalog.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {

        CustomErrorResponse customErrorResponse = new CustomErrorResponse(NOT_FOUND, ex.getMessage());

        return new ResponseEntity<Object>(
                customErrorResponse, new HttpHeaders(), customErrorResponse.getStatus());
    }

    @ExceptionHandler(ApiServiceException.class)
    protected ResponseEntity<Object> handleApiServiceException(ApiServiceException ex) {

        CustomErrorResponse errorResponse = new CustomErrorResponse(NOT_FOUND, ex.getMessage());

        return new ResponseEntity<Object>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
    }
}
