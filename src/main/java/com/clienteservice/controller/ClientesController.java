package com.clienteservice.controller;

import com.clienteservice.controller.json.AtualizarClienteJson;
import com.clienteservice.controller.json.ClienteJson;
import com.clienteservice.domain.Cliente;
import com.clienteservice.usecase.AtualizarClienteUseCase;
import com.clienteservice.usecase.CriarClienteUseCase;
import com.clienteservice.usecase.ExcluirClienteUseCase;
import com.clienteservice.usecase.ListarClientesUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes/")
public class ClientesController {

    private final CriarClienteUseCase criarClienteUseCase;
    private final AtualizarClienteUseCase atualizarClienteUseCase;
    private final ListarClientesUseCase listarClientesUseCase;
    private final ExcluirClienteUseCase excluirClienteUseCase;

    public ClientesController(CriarClienteUseCase criarClienteUseCase, AtualizarClienteUseCase atualizarClienteUseCase, ListarClientesUseCase listarClientesUseCase, ExcluirClienteUseCase excluirClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.atualizarClienteUseCase = atualizarClienteUseCase;
        this.listarClientesUseCase = listarClientesUseCase;
        this.excluirClienteUseCase = excluirClienteUseCase;
    }


    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody ClienteJson clienteJson) {
        Cliente novoCliente = criarClienteUseCase.criarCliente(clienteJson.toDTO());
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Cliente>> listarClientes() {
        return ResponseEntity.ok(listarClientesUseCase.listarTodos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable String cpf) {
        var cliente = Optional.of(listarClientesUseCase.buscarPorCpf(cpf));
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable String cpf, @Valid @RequestBody AtualizarClienteJson atualizarClienteJson) {
        Cliente clienteAtualizado = atualizarClienteUseCase.atualizarCliente(cpf, atualizarClienteJson.nome());
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> excluirCliente(@PathVariable String cpf) {
        excluirClienteUseCase.excluirPorCpf(cpf);
        return ResponseEntity.noContent().build();
    }
}

