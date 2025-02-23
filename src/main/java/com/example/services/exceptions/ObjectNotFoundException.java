package com.example.services.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    private final long serialVersionUID = 1L;

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(String message) {

        super(message);
    }
}