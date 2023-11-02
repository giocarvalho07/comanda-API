package com.comandaai.dto;

import org.springframework.stereotype.Component;

@Component
public class PedidoClienteDTO {

    private Long idPedido;
    private String dataPedido;
    private String clienteNome;
    private String clienteSobrenome;
    private String dataPagamento;
    private String identificadorPedido;

    public PedidoClienteDTO(){}

    public PedidoClienteDTO(Long idPedido, String identificadorPedido,String dataPedido, String clienteNome, String clienteSobrenome, String dataPagamento) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.clienteNome = clienteNome;
        this.clienteSobrenome = clienteSobrenome;
        this.dataPagamento = dataPagamento;
        this.identificadorPedido = identificadorPedido;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteSobrenome() {
        return clienteSobrenome;
    }

    public void setClienteSobrenome(String clienteSobrenome) {
        this.clienteSobrenome = clienteSobrenome;
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

    @Override
    public String toString() {
        return "PedidoClienteDTO{" +
                "idPedido=" + idPedido +
                ", dataPedido='" + dataPedido + '\'' +
                ", clienteNome='" + clienteNome + '\'' +
                ", clienteSobrenome='" + clienteSobrenome + '\'' +
                ", identificadorPedido='" + identificadorPedido + '\'' +
                ", dataPagamento='" + dataPagamento + '\'' +
                '}';
    }
}
