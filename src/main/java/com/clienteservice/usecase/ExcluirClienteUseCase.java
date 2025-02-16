package com.clienteservice.usecase;

import com.clienteservice.domain.ValidadorCpf;
import com.clienteservice.exception.FormatoInvalidoException;
import com.clienteservice.gateway.ClienteGateway;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExcluirClienteUseCase {

    private final ClienteGateway clienteGateway;

    public ExcluirClienteUseCase(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Transactional
    public void excluirPorCpf(String cpf) {
        if (!ValidadorCpf.ehCPFValido(cpf)) {
            throw new FormatoInvalidoException("cpf", cpf);
        }

        clienteGateway.excluirPorCpf(cpf);
    }
}
