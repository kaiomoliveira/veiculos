package com.example.resources.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends com.example.resources.exceptions.StandardError {

    private final long serialVersionUID = 1L;

    private List<com.example.resources.exceptions.FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(LocalDateTime timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<com.example.resources.exceptions.FieldMessage> getErrors() {
        return errors;
    }

    public void addErrors(String fieldName, String message) {
        this.errors.add(new com.example.resources.exceptions.FieldMessage(fieldName, message));
    }
}
