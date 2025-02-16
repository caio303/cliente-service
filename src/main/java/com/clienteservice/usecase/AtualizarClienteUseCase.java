package com.clienteservice.usecase;

import com.clienteservice.domain.Cliente;
import com.clienteservice.exception.ClienteInexistenteException;
import com.clienteservice.gateway.ClienteGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtualizarClienteUseCase {

    private final ClienteGateway clienteGateway;

    public AtualizarClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Transactional
    public Cliente atualizarCliente(String cpf, String novoNome) {
        var clienteEntity = clienteGateway.buscarPorCpf(cpf, true);
        if (clienteEntity == null) {
            throw new ClienteInexistenteException(cpf);
        }

        clienteEntity.setNome(novoNome);

        return new Cliente(cpf, novoNome, true);
    }
}
