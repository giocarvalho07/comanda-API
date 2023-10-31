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
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_forma_pagamento;

    private String nome_pagamento;

    @JsonIgnore // Adicione esta anotação para evitar que a lista seja incluída na representação JSON
    @OneToMany(mappedBy = "forma_pagamento")
    private List<Pedido> pedidos;

    public FormaPagamento(){}

    public FormaPagamento(Long id_forma_pagamento, String nome_pagamento, List<Pedido> pedidos) {
        this.id_forma_pagamento = id_forma_pagamento;
        this.nome_pagamento = nome_pagamento;
        this.pedidos = pedidos;
    }

    public Long getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    public void setId_forma_pagamento(Long id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    public String getNome_pagamento() {
        return nome_pagamento;
    }

    public void setNome_pagamento(String nome_pagamento) {
        this.nome_pagamento = nome_pagamento;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "id_forma_pagamento=" + id_forma_pagamento +
                ", nome_pagamento='" + nome_pagamento + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
