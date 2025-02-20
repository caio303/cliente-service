package com.clienteservice.controller.exceptionhandler;

import com.clienteservice.exception.BaseHttpMappedException;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Hidden
@RestControllerAdvice
public class ClientesExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ClientesExceptionHandler.class);

    @ExceptionHandler(BaseHttpMappedException.class)
    public ResponseEntity<Error> handleBaseHttpMappedException(HttpServletRequest req, BaseHttpMappedException ex) {
        log(ex.getHttpStatus(), req.getRequestURI());
        return ResponseEntity.status(ex.getHttpStatus()).body(new Error(ex.getHttpStatus(), ex.getLocalizedMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handlerException(HttpServletRequest req, BaseHttpMappedException ex) {
        log(ex.getHttpStatus(), req.getRequestURI());
        return ResponseEntity.internalServerError().body(new Error("Ocorreu um erro interno, entre em contato ou tente mais tarde..."));
    }

    private void log(HttpStatus status, String uri) {
        log.warn("{}: URL={}", status.name(), uri);
    }
}
