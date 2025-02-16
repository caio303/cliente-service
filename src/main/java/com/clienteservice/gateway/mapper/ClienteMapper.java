package com.clienteservice.gateway.mapper;

import com.clienteservice.domain.Cliente;

public class ClienteMapper {

    public Cliente toDomain(com.clienteservice.entity.Cliente entity) {
        return new Cliente(entity.getCpf(), entity.getNome(), true);
    }
}
