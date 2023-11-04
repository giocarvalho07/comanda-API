package com.comandaai.query;
public class TotalPedidosResponse {
    private Long totalPedidos;

    public TotalPedidosResponse(Long totalPedidos) {
        this.totalPedidos = totalPedidos;
    }

    public Long getTotalPedidos() {
        return totalPedidos;
    }
}
