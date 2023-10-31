package com.comandaai.service;

import com.comandaai.domain.Categoria;
import com.comandaai.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Método para criar uma nova categoria
    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Método para buscar uma categoria por ID
    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Método para listar todas as categorias
    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    // Método para atualizar uma categoria
    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Método para excluir uma categoria por ID
    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
