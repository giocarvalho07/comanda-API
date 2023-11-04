package com.comandaai.query;

public class TotalPedidosPorMesResponse {
    private int mes;
    private int totalPedidos;

    public TotalPedidosPorMesResponse(int mes, int totalPedidos) {
        this.mes = mes;
        this.totalPedidos = totalPedidos;
    }

    public int getMes() {
        return mes;
    }

    public int getTotalPedidos() {
        return totalPedidos;
    }
}
