package com.clienteservice.usecase;

import com.clienteservice.domain.Cliente;
import com.clienteservice.domain.ValidadorCpf;
import com.clienteservice.exception.ClienteInexistenteException;
import com.clienteservice.exception.FormatoInvalidoException;
import com.clienteservice.gateway.ClienteGateway;
import com.clienteservice.gateway.mapper.ClienteMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ListarClientesUseCase {

    private final ClienteMapper clienteMapper = new ClienteMapper();
    private final ClienteGateway clienteGateway;

    public ListarClientesUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public Collection<Cliente> listarTodos() {
        return clienteGateway.listarAtivos();
    }

    public Cliente buscarPorCpf(String cpf) {
        if (!ValidadorCpf.ehCPFValido(cpf)) {
            throw new FormatoInvalidoException("cpf", cpf);
        }

        var entity = clienteGateway.buscarPorCpf(cpf, true);
        if (entity == null) {
            throw new ClienteInexistenteException(cpf);
        }

        return clienteMapper.toDomain(entity);
    }
}
