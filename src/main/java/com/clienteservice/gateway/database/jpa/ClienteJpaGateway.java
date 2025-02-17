package com.clienteservice.gateway.database.jpa;

import com.clienteservice.domain.Cliente;
import com.clienteservice.gateway.ClienteGateway;
import com.clienteservice.gateway.database.jpa.repository.ClienteRepository;
import com.clienteservice.gateway.mapper.ClienteMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ClienteJpaGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = new ClienteMapper();

    public ClienteJpaGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public boolean existePorCpf(String cpf) {
        return clienteRepository.existsByCpf(cpf);
    }

    @Override
    public void cadastrar(Cliente cliente) {
        var entity = new com.clienteservice.entity.Cliente(null, cliente.nome(), cliente.cpf(), true);
        clienteRepository.save(entity);
    }

    @Override
    public com.clienteservice.entity.Cliente buscarPorCpf(String cpf, boolean ativo) {
        if (ativo) {
            return clienteRepository.findByCpfAndAtivoTrue(cpf);
        } else {
            return clienteRepository.findByCpf(cpf);
        }
    }

    @Override
    public Collection<Cliente> listarAtivos() {
        var ativos = clienteRepository.findAllByAtivoTrue();
        return ativos.stream().map(clienteMapper::toDomain).toList();
    }
}
