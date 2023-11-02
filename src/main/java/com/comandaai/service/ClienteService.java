package com.comandaai.service;

import com.comandaai.domain.Cliente;
import com.comandaai.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para criar um novo cliente
    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para buscar um cliente por ID
    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Método para listar todos os clientes
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    // Método para atualizar um cliente
    public Cliente atualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para excluir um cliente por ID
    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
