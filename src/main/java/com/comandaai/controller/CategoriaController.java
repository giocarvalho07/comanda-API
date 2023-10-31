package com.comandaai.controller;

import com.comandaai.domain.Categoria;
import com.comandaai.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Listar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategoria() {
        List<Categoria> categoriaList = categoriaService.listarTodasCategorias();
        return ResponseEntity.ok().body(categoriaList);
    }

    // Buscar categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.buscarCategoriaPorId(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok().body(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova categoria
    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.criarCategoria(categoria);
        return ResponseEntity.ok().body(novaCategoria);
    }

    // Atualizar uma categoria por ID
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> categoriaExistente = categoriaService.buscarCategoriaPorId(id);
        if (categoriaExistente.isPresent()) {
            categoria.setId_categoria(id);
            Categoria categoriaAtualizada = categoriaService.atualizarCategoria(categoria);
            return ResponseEntity.ok().body(categoriaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir uma categoria por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
        categoriaService.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }


}
