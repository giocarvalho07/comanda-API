package com.comandaai.controller;

import com.comandaai.domain.Cliente;
import com.comandaai.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/clientes")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "https://comanda-api.onrender.com"})
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para criar um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteService.criarCliente(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodosClientes() {
        List<Cliente> clientes = clienteService.listarTodosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // Endpoint para atualizar um cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId_cliente(id);
        Cliente clienteAtualizado = clienteService.atualizarCliente(cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }

    // Endpoint para excluir um cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
