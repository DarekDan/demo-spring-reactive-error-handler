package com.example.demospringreactiveerrorhandler;

public class MissingNameException extends RuntimeException {

    public final String errorCode = "NMS-API-001";

    private String message;

    public MissingNameException(String message) {
        super(message);
        this.message = message;
    }

    public MissingNameException() {
    }
}
