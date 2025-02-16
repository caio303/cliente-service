package com.clienteservice.service;

import com.clienteservice.entity.Cliente;
import org.springframework.stereotype.Service;
import com.clienteservice.gateway.database.jpa.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ClienteService {


    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

     public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

     public Optional<Cliente> obterCliente(Long id) {
        return clienteRepository.findById(id);
    }

     public Cliente atualizarCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
