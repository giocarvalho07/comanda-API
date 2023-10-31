package com.comandaai.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
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
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produto;

    private String nome_produto;

    private String descricao_produto;

    private Double preco_produto;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private Categoria categoria_produto;

    @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    private Tipo tipo_produto;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "produto_item")
    private List<ItemPedido> itemPedidos;


    public Produto() {
    }

    public Produto(Long id_produto, String nome_produto, String descricao_produto, Double preco_produto, Categoria categoria_produto, Tipo tipo_produto, List<ItemPedido> itemPedidos) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.descricao_produto = descricao_produto;
        this.preco_produto = preco_produto;
        this.categoria_produto = categoria_produto;
        this.tipo_produto = tipo_produto;
        this.itemPedidos = itemPedidos;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(Double preco_produto) {
        this.preco_produto = preco_produto;
    }

    public Categoria getCategoria_produto() {
        return categoria_produto;
    }

    public void setCategoria_produto(Categoria categoria_produto) {
        this.categoria_produto = categoria_produto;
    }

    public Tipo getTipo_produto() {
        return tipo_produto;
    }

    public void setTipo_produto(Tipo tipo_produto) {
        this.tipo_produto = tipo_produto;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id_produto=" + id_produto +
                ", nome_produto='" + nome_produto + '\'' +
                ", descricao_produto='" + descricao_produto + '\'' +
                ", preco_produto=" + preco_produto +
                ", categoria_produto=" + categoria_produto +
                ", tipo_produto=" + tipo_produto +
                ", itemPedidos=" + itemPedidos +
                '}';
    }
}
