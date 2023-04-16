package com.example.demospringreactiveerrorhandler;

import lombok.Getter;

@Getter
public enum ErrorAttributesKey {
    CODE("code"),
    MESSAGE("message"),
    TIME("timestamp"),
    REMOTEIP("remoteIpAddress");

    private final String key;

    ErrorAttributesKey(String key) {
        this.key = key;
    }
}
