package com.clienteservice.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseHttpMappedException extends RuntimeException {

    public abstract HttpStatus getHttpStatus();

    protected BaseHttpMappedException(String message) {
        super(message);
    }

}