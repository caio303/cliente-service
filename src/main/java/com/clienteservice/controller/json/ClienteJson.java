package com.clienteservice.controller.json;

import com.clienteservice.usecase.dto.ClienteDTO;

public record ClienteJson(
        String cpf,
        String nome
) {

    public ClienteDTO toDTO() {
        return new ClienteDTO(null, cpf, nome, true);
    }
}
