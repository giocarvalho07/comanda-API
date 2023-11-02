package com.comandaai.service;

import com.comandaai.domain.Pedido;
import com.comandaai.dto.PedidoClienteDTO;
import com.comandaai.dto.PedidoFormaPagamentoDTO;
import com.comandaai.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Object[]> contarPedidosPorCliente() {
        return pedidoRepository.countPedidosPorCliente();
    }

    public List<PedidoClienteDTO> listarPedidosComCliente() {
        List<PedidoClienteDTO> pedidosComCliente = new ArrayList<>();
        List<Pedido> pedidos = pedidoRepository.findAll(); // Ou use o método adequado para buscar pedidos

        for (Pedido pedido : pedidos) {
            PedidoClienteDTO dto = new PedidoClienteDTO();
            dto.setIdPedido(pedido.getId_pedido());
            dto.setDataPedido(pedido.getData_pedido());
            dto.setClienteNome(pedido.getClientes().getNome_cliente());
            dto.setIdentificadorPedido(pedido.getIdentificador());
            dto.setDataPagamento(pedido.getData_pagamento());
            dto.setClienteSobrenome(pedido.getClientes().getSobrenome_cliente());
            // Preencha outros campos do DTO conforme necessário

            pedidosComCliente.add(dto);
        }

        return pedidosComCliente;
    }


    public List<PedidoFormaPagamentoDTO> listarPedidosComFormaPagamento() {
        List<PedidoFormaPagamentoDTO> pedidosComFormaPagamento = new ArrayList<>();
        List<Pedido> pedidos = pedidoRepository.findAll(); // Ou use o método adequado para buscar pedidos

        for (Pedido pedido : pedidos) {
            PedidoFormaPagamentoDTO dto = new PedidoFormaPagamentoDTO();
            dto.setIdPedido(pedido.getId_pedido());
            dto.setDataPagamento(pedido.getData_pagamento());
            dto.setIdentificadorPedido(pedido.getIdentificador());
            dto.setFormaPagamento(pedido.getForma_pagamento().getNome_pagamento());
            // Preencha outros campos do DTO conforme necessário

            pedidosComFormaPagamento.add(dto);
        }

        return pedidosComFormaPagamento;
    }

}
