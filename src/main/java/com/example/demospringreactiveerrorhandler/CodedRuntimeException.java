package com.example.demospringreactiveerrorhandler;

public abstract class CodedRuntimeException extends RuntimeException{

    protected volatile String errorCode = null;

    protected CodedRuntimeException(String message) {

    }

    protected CodedRuntimeException() {
    }
}
