package com.clienteservice.gateway.database.jpa.repository;

import com.clienteservice.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByAtivoTrue();

    Cliente findByCpfAndAtivoTrue(String cpf);

    Cliente findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}