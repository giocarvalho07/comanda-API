package com.comandaai.service;

import com.comandaai.domain.FormaPagamento;
import com.comandaai.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FormaPagamentoService {

    private final FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    public FormaPagamentoService(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    public FormaPagamento criarFormaPagamento(FormaPagamento formaPagamento) {
        // Adicione aqui qualquer lógica de validação ou processamento necessário antes de salvar a forma de pagamento
        return formaPagamentoRepository.save(formaPagamento);
    }

    public List<FormaPagamento> listarTodasFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    public Optional<FormaPagamento> buscarFormaPagamentoPorId(Long id) {
        return formaPagamentoRepository.findById(id);
    }

    public FormaPagamento atualizarFormaPagamento(FormaPagamento formaPagamento) {
        // Adicione aqui lógica de validação ou processamento adicional, se necessário
        return formaPagamentoRepository.save(formaPagamento);
    }

    public void excluirFormaPagamento(Long id) {
        formaPagamentoRepository.deleteById(id);
    }
}
