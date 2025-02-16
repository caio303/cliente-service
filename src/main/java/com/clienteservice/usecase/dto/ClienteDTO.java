package com.clienteservice.usecase.dto;

public record ClienteDTO (
        Long id,
        String cpf,
        String nome,
        Boolean ativo
) {
}
