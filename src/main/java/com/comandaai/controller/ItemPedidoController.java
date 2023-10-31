package com.comandaai.controller;

import com.comandaai.domain.ItemPedido;
import com.comandaai.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/item_pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    // Endpoint para criar um novo item de pedido
    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        ItemPedido novoItemPedido = itemPedidoService.criarItemPedido(itemPedido);
        return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
    }

    // Endpoint para buscar um item de pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarItemPedidoPorId(@PathVariable Long id) {
        Optional<ItemPedido> itemPedido = itemPedidoService.buscarItemPedidoPorId(id);
        return itemPedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para listar todos os itens de pedido
    @GetMapping
    public ResponseEntity<List<ItemPedido>> listarTodosItensPedido() {
        List<ItemPedido> itensPedido = itemPedidoService.listarTodosItensPedido();
        return new ResponseEntity<>(itensPedido, HttpStatus.OK);
    }

    // Endpoint para atualizar um item de pedido
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        if (!itemPedidoService.buscarItemPedidoPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        itemPedido.setId_item_pedido(id);
        ItemPedido itemPedidoAtualizado = itemPedidoService.atualizarItemPedido(itemPedido);
        return new ResponseEntity<>(itemPedidoAtualizado, HttpStatus.OK);
    }

    // Endpoint para excluir um item de pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirItemPedido(@PathVariable Long id) {
        itemPedidoService.excluirItemPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
