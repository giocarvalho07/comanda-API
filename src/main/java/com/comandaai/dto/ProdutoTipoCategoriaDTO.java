package com.comandaai.dto;

import org.springframework.stereotype.Component;

@Component
public class ProdutoTipoCategoriaDTO {

    private Long idProduto;
    private String nomeProduto;
    private String tipoProduto;
    private String categoriaProduto;

    public ProdutoTipoCategoriaDTO(){}

    public ProdutoTipoCategoriaDTO(Long idProduto, String nomeProduto, String tipoProduto, String categoriaProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipoProduto = tipoProduto;
        this.categoriaProduto = categoriaProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    @Override
    public String toString() {
        return "ProdutoTipoCategoriaDTO{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", tipoProduto='" + tipoProduto + '\'' +
                ", categoriaProduto='" + categoriaProduto + '\'' +
                '}';
    }
}
