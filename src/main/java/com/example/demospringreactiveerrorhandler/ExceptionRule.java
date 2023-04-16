package com.example.demospringreactiveerrorhandler;

import org.springframework.http.HttpStatus;

record ExceptionRule(Class<?> exceptionClass, HttpStatus status) {

}
