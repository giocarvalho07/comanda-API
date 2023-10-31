package com.comandaai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Getter
@Setter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item_pedido;

    private int quantidade;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private Pedido pedido_item;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private Produto produto_item;

    public ItemPedido(){
    }

    public ItemPedido(Long id_item_pedido, int quantidade, Pedido pedido, Pedido pedido_item, Produto produto_item) {
        this.id_item_pedido = id_item_pedido;
        this.quantidade = quantidade;
        this.pedido_item = pedido_item;
        this.produto_item = produto_item;
    }

    public Long getId_item_pedido() {
        return id_item_pedido;
    }

    public void setId_item_pedido(Long id_item_pedido) {
        this.id_item_pedido = id_item_pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido_item() {
        return pedido_item;
    }

    public void setPedido_item(Pedido pedido_item) {
        this.pedido_item = pedido_item;
    }

    public Produto getProduto_item() {
        return produto_item;
    }

    public void setProduto_item(Produto produto_item) {
        this.produto_item = produto_item;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "id_item_pedido=" + id_item_pedido +
                ", quantidade=" + quantidade +
                ", pedido_item=" + pedido_item +
                ", produto_item=" + produto_item +
                '}';
    }
}


