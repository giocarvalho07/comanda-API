package com.comandaai.service;

import com.comandaai.domain.Produto;
import com.comandaai.dto.ProdutoTipoCategoriaDTO;
import com.comandaai.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para criar um novo produto
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Método para buscar um produto por ID
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Método para listar todos os produtos
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    // Método para atualizar um produto
    public Produto atualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Método para excluir um produto por ID
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<ProdutoTipoCategoriaDTO> listarProdutosComTipoCategoria() {
        List<ProdutoTipoCategoriaDTO> produtosComTipoCategoria = new ArrayList<>();
        List<Produto> produtos = produtoRepository.findAll(); // Ou use o método adequado para buscar produtos

        for (Produto produto : produtos) {
            ProdutoTipoCategoriaDTO dto = new ProdutoTipoCategoriaDTO();
            dto.setIdProduto(produto.getId_produto());
            dto.setNomeProduto(produto.getNome_produto());
            dto.setTipoProduto(produto.getTipo_produto().getNome_tipo());
            dto.setCategoriaProduto(produto.getCategoria_produto().getNome());
            // Preencha outros campos do DTO conforme necessário

            produtosComTipoCategoria.add(dto);
        }

        return produtosComTipoCategoria;
    }

}
