package com.comandaai.query;

public class PedidosPorFormaPagamento {
    private String formaPagamento;
    private Long quantidadePedidos;

    public PedidosPorFormaPagamento(String formaPagamento, Long quantidadePedidos) {
        this.formaPagamento = formaPagamento;
        this.quantidadePedidos = quantidadePedidos;
    }

   public PedidosPorFormaPagamento(){}

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getQuantidadePedidos() {
        return quantidadePedidos;
    }

    public void setQuantidadePedidos(Long quantidadePedidos) {
        this.quantidadePedidos = quantidadePedidos;
    }

    @Override
    public String toString() {
        return "PedidosPorFormaPagamento{" +
                "formaPagamento='" + formaPagamento + '\'' +
                ", quantidadePedidos=" + quantidadePedidos +
                '}';
    }
}
