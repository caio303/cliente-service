package com.clienteservice.gateway;

import com.clienteservice.domain.Cliente;

import java.util.Collection;

public interface ClienteGateway {


    boolean existePorCpf(String cpf);

    void cadastrar(Cliente cliente);

    com.clienteservice.entity.Cliente buscarPorCpf(String cpf, boolean ativo);

    Collection<Cliente> listarAtivos();
}
