package com.comandaai.controller;

import com.comandaai.dto.PedidoClienteDTO;
import com.comandaai.dto.PedidoFormaPagamentoDTO;
import com.comandaai.dto.ProdutoTipoCategoriaDTO;
import com.comandaai.service.PedidoService;
import com.comandaai.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tabela")
public class TabelaController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos-cliente")
    public List<PedidoClienteDTO> listarPedidosComCliente() {
        return pedidoService.listarPedidosComCliente();
    }

    @GetMapping("/pedidos-forma-pagamento")
    public List<PedidoFormaPagamentoDTO> listarPedidosComFormaPagamento() {
        return pedidoService.listarPedidosComFormaPagamento();
    }

    @GetMapping("/produtos-tipo-categoria")
    public List<ProdutoTipoCategoriaDTO> listarProdutosComTipoCategoria() {
        return produtoService.listarProdutosComTipoCategoria();
    }

}
