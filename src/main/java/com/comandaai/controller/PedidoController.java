package com.comandaai.controller;

import com.comandaai.domain.Pedido;
import com.comandaai.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/pedidos")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "https://comanda-api.onrender.com"})
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Endpoint para criar um novo pedido
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    // Endpoint para buscar um pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(id);
        return pedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para listar todos os pedidos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodosPedidos() {
        List<Pedido> pedidos = pedidoService.listarTodosPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    // Endpoint para atualizar um pedido
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        if (!pedidoService.buscarPedidoPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedido.setId_pedido(id);
        Pedido pedidoAtualizado = pedidoService.atualizarPedido(pedido);
        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
    }

    // Endpoint para excluir um pedido por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
