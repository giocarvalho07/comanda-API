package com.comandaai.dto;

import org.springframework.stereotype.Component;

@Component
public class PedidoFormaPagamentoDTO {

    private Long idPedido;
    private String dataPagamento;
    private String identificadorPedido;
    private String formaPagamento;

    public PedidoFormaPagamentoDTO(){}

    public PedidoFormaPagamentoDTO(Long idPedido, String dataPagamento, String identificadorPedido, String formaPagamento) {
        this.idPedido = idPedido;
        this.dataPagamento = dataPagamento;
        this.identificadorPedido = identificadorPedido;
        this.formaPagamento = formaPagamento;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getIdentificadorPedido() {
        return identificadorPedido;
    }

    public void setIdentificadorPedido(String identificadorPedido) {
        this.identificadorPedido = identificadorPedido;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "PedidoFormaPagamentoDTO{" +
                "idPedido=" + idPedido +
                ", dataPagamento='" + dataPagamento + '\'' +
                ", identificadorPedido='" + identificadorPedido + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }
}
