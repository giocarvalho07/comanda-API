package com.comandaai.service;

import com.comandaai.domain.Pedido;
import com.comandaai.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Método para criar um novo pedido
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Método para buscar um pedido por ID
    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Método para listar todos os pedidos
    public List<Pedido> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    // Método para atualizar um pedido
    public Pedido atualizarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Método para excluir um pedido por ID
    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
