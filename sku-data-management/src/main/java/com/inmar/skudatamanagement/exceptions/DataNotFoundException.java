package com.inmar.skudatamanagement.exceptions;

public class DataNotFoundException extends RuntimeException {
    private String message;

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
