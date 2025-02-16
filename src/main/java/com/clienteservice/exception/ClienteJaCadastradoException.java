package com.clienteservice.exception;

import org.springframework.http.HttpStatus;

public class ClienteJaCadastradoException extends BaseHttpMappedException {

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }

    public ClienteJaCadastradoException(String cpf) {
        super("Cliente ja cadastrado. cpf=" + cpf);
    }
}
