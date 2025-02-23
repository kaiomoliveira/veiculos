package com.example.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    private final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String message, Throwable cause){
        super(message, cause);
    }

    public DataIntegrityViolationException(String message){
        super(message);
    }

}