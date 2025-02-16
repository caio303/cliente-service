package com.clienteservice.domain;

import com.clienteservice.exception.FormatoInvalidoException;

public record Cliente (
        String cpf,
        String nome,
        boolean ativo
) {

    public Cliente(String cpf, String nome, boolean ativo) {
        if (cpf == null || cpf.isBlank()) {
            throw new FormatoInvalidoException("cpf", cpf);
        }

        if (nome == null || nome.isBlank()) {
            throw new FormatoInvalidoException("nome", nome);
        }

        this.cpf = cpf;
        this.nome = nome;
        this.ativo = ativo;
    }

}
