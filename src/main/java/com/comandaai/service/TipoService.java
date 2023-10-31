package com.comandaai.service;

import com.comandaai.domain.Tipo;
import com.comandaai.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    // Método para criar um novo tipo
    public Tipo criarTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    // Método para buscar um tipo por ID
    public Optional<Tipo> buscarTipoPorId(Long id) {
        return tipoRepository.findById(id);
    }

    // Método para listar todos os tipos
    public List<Tipo> listarTodosTipos() {
        return tipoRepository.findAll();
    }

    // Método para atualizar um tipo
    public Tipo atualizarTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    // Método para excluir um tipo por ID
    public void excluirTipo(Long id) {
        tipoRepository.deleteById(id);
    }
}
