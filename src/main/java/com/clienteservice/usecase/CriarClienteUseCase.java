package com.clienteservice.usecase;

import com.clienteservice.domain.Cliente;
import com.clienteservice.exception.ClienteJaCadastradoException;
import com.clienteservice.gateway.ClienteGateway;
import com.clienteservice.usecase.dto.ClienteDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public CriarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Transactional
    public Cliente criarCliente(ClienteDTO dto) {
        boolean clienteJaCadastrado = clienteGateway.existePorCpf(dto.cpf());
        if (clienteJaCadastrado) {
            throw new ClienteJaCadastradoException(dto.cpf());
        }

        var cliente = new Cliente(dto.cpf(), dto.nome(), true);
        clienteGateway.cadastrar(cliente);

        return cliente;
    }
}
