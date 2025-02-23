package com.example.resources.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<com.example.resources.exceptions.StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {
        com.example.resources.exceptions.StandardError error = new com.example.resources.exceptions.StandardError(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Object not found",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<com.example.resources.exceptions.StandardError> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        com.example.resources.exceptions.StandardError error = new com.example.resources.exceptions.StandardError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<com.example.resources.exceptions.StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        com.example.resources.exceptions.StandardError error = new com.example.resources.exceptions.StandardError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Data Integrity Violation",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<com.example.resources.exceptions.StandardError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        com.example.resources.exceptions.ValidationError errors = new com.example.resources.exceptions.ValidationError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Data Validation Error",
                "Field Validation Error",
                request.getRequestURI()
        );

        for (FieldError x : ex.getBindingResult().getFieldErrors()) {
            errors.addErrors(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
