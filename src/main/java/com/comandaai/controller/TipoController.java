package com.comandaai.controller;

import com.comandaai.domain.Tipo;
import com.comandaai.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tipo")  // Você pode manter o mesmo caminho base ou modificá-lo conforme necessário
public class TipoController {

    @Autowired
    private TipoService tipoService;

    // Listar todos os tipos
    @GetMapping
    public ResponseEntity<List<Tipo>> listarTipo() {
        List<Tipo> tipoList = tipoService.listarTodosTipos();
        return ResponseEntity.ok().body(tipoList);
    }

    // Buscar tipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tipo> buscarTipoPorId(@PathVariable Long id) {
        Optional<Tipo> tipo = tipoService.buscarTipoPorId(id);
        if (tipo.isPresent()) {
            return ResponseEntity.ok().body(tipo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar um novo tipo
    @PostMapping
    public ResponseEntity<Tipo> criarTipo(@RequestBody Tipo tipo) {
        Tipo novoTipo = tipoService.criarTipo(tipo);
        return ResponseEntity.ok().body(novoTipo);
    }

    // Atualizar um tipo por ID
    @PutMapping("/{id}")
    public ResponseEntity<Tipo> atualizarTipo(@PathVariable Long id, @RequestBody Tipo tipo) {
        Optional<Tipo> tipoExistente = tipoService.buscarTipoPorId(id);
        if (tipoExistente.isPresent()) {
            tipo.setId_tipo(id);
            Tipo tipoAtualizado = tipoService.atualizarTipo(tipo);
            return ResponseEntity.ok().body(tipoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Excluir um tipo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTipo(@PathVariable Long id) {
        tipoService.excluirTipo(id);
        return ResponseEntity.noContent().build();
    }
}
