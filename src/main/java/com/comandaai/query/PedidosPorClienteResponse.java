package com.comandaai.query;

public class PedidosPorClienteResponse {
    private String clienteNome;
    private int quantidadePedidos;

    public PedidosPorClienteResponse(String clienteNome, int quantidadePedidos) {
        this.clienteNome = clienteNome;
        this.quantidadePedidos = quantidadePedidos;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public int getQuantidadePedidos() {
        return quantidadePedidos;
    }
}
