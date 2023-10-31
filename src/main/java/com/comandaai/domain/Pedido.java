package com.comandaai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pedido;

    private String identificador;

    private String data_pedido;

    private String observacao;

    private String data_entrega;

    private Double frete;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private FormaPagamento forma_pagamento;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "pedido_item")
    private List<ItemPedido> itemPedidos;


    public Pedido(){
    }

    public Pedido(Long id_pedido, String identificador, String data_pedido, String observacao, String data_entrega, Double frete, FormaPagamento forma_pagamento, List<ItemPedido> itemPedidos) {
        this.id_pedido = id_pedido;
        this.identificador = identificador;
        this.data_pedido = data_pedido;
        this.observacao = observacao;
        this.data_entrega = data_entrega;
        this.frete = frete;
        this.forma_pagamento = forma_pagamento;
        this.itemPedidos = itemPedidos;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public FormaPagamento getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(FormaPagamento forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id_pedido=" + id_pedido +
                ", identificador='" + identificador + '\'' +
                ", data_pedido='" + data_pedido + '\'' +
                ", observacao='" + observacao + '\'' +
                ", data_entrega='" + data_entrega + '\'' +
                ", frete=" + frete +
                ", forma_pagamento=" + forma_pagamento +
                ", itemPedidos=" + itemPedidos +
                '}';
    }
}
