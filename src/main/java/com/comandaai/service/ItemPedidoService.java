package com.comandaai.service;

import com.comandaai.domain.ItemPedido;
import com.comandaai.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    // Método para criar um novo item de pedido
    public ItemPedido criarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    // Método para buscar um item de pedido por ID
    public Optional<ItemPedido> buscarItemPedidoPorId(Long id) {
        return itemPedidoRepository.findById(id);
    }

    // Método para listar todos os itens de pedido
    public List<ItemPedido> listarTodosItensPedido() {
        return itemPedidoRepository.findAll();
    }

    // Método para atualizar um item de pedido
    public ItemPedido atualizarItemPedido(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    // Método para excluir um item de pedido por ID
    public void excluirItemPedido(Long id) {
        itemPedidoRepository.deleteById(id);
    }

}
