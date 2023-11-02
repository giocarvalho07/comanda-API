package com.comandaai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nome_cliente;

    private String sobrenome_cliente;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "clientes")
    private List<Pedido> pedidos;

    public Cliente(){}

    public Cliente(Long id_cliente, String nome_cliente, String sobrenome_cliente, List<Pedido> pedidos) {
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.sobrenome_cliente = sobrenome_cliente;
        this.pedidos = pedidos;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getSobrenome_cliente() {
        return sobrenome_cliente;
    }

    public void setSobrenome_cliente(String sobrenome_cliente) {
        this.sobrenome_cliente = sobrenome_cliente;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nome_cliente='" + nome_cliente + '\'' +
                ", sobrenome_cliente='" + sobrenome_cliente + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
