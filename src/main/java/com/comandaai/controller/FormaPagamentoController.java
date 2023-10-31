package com.comandaai.controller;

import com.comandaai.domain.FormaPagamento;
import com.comandaai.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    // Endpoint para criar uma nova forma de pagamento
    @PostMapping
    public ResponseEntity<FormaPagamento> criarFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
        FormaPagamento novaFormaPagamento = formaPagamentoService.criarFormaPagamento(formaPagamento);
        return new ResponseEntity<>(novaFormaPagamento, HttpStatus.CREATED);
    }

    // Endpoint para buscar uma forma de pagamento por ID
    @GetMapping("/{id}")
    public ResponseEntity<FormaPagamento> buscarFormaPagamentoPorId(@PathVariable Long id) {
        Optional<FormaPagamento> formaPagamento = formaPagamentoService.buscarFormaPagamentoPorId(id);
        return formaPagamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para listar todas as formas de pagamento
    @GetMapping
    public ResponseEntity<List<FormaPagamento>> listarTodasFormasPagamento() {
        List<FormaPagamento> formasPagamento = formaPagamentoService.listarTodasFormasPagamento();
        return new ResponseEntity<>(formasPagamento, HttpStatus.OK);
    }

    // Endpoint para atualizar uma forma de pagamento
    @PutMapping("/{id}")
    public ResponseEntity<FormaPagamento> atualizarFormaPagamento(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
        if (!formaPagamentoService.buscarFormaPagamentoPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        formaPagamento.setId_forma_pagamento(id);
        FormaPagamento formaPagamentoAtualizada = formaPagamentoService.atualizarFormaPagamento(formaPagamento);
        return new ResponseEntity<>(formaPagamentoAtualizada, HttpStatus.OK);
    }

    // Endpoint para excluir uma forma de pagamento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFormaPagamento(@PathVariable Long id) {
        formaPagamentoService.excluirFormaPagamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
