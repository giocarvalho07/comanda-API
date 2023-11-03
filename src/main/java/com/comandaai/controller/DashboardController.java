package com.comandaai.controller;

import com.comandaai.query.PedidosPorFormaPagamento;
import com.comandaai.repository.ClienteRepository;
import com.comandaai.repository.PedidoRepository;
import com.comandaai.repository.ProdutoRepository;
import com.comandaai.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/dashboard")
@CrossOrigin(origins = {"http://127.0.0.1:5500", "https://comanda-api.onrender.com"})
public class DashboardController {

    // Injeção de dependência do repositório de pedidos
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/total-pedidos")
    public Long getTotalPedidos() {
        Long totalPedidos = pedidoRepository.count();
        return totalPedidos;
    }


    @GetMapping("/total-pedidos-por-mes")
    public List<Object[]> getTotalPedidosPorMes() {
        List<Object[]> totalPedidosPorMes = pedidoRepository.getTotalPedidosPorMes();
        return totalPedidosPorMes;
    }

    @GetMapping("/total-pedidos-produtos")
    public ResponseEntity<Map<String, Long>> getPedidosXProdutosTotal() {
        Map<String, Long> result = new HashMap<>();
        Long totalPedidos = pedidoRepository.count(); // Conta o número total de pedidos
        Long totalProdutos = produtoRepository.count(); // Conta o número total de produtos

        result.put("totalPedidos", totalPedidos);
        result.put("totalProdutos", totalProdutos);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/total-clientes")
    public ResponseEntity<Map<String, Long>> getClientesTotal() {
        Map<String, Long> result = new HashMap<>();
        Long totalClientes = clienteRepository.count(); // Conta o número total de clientes

        result.put("totalClientes", totalClientes);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/pedidos-forma-pagamento")
    public List<PedidosPorFormaPagamento> getPedidosPorFormaPagamento() {
        List<Object[]> results = pedidoRepository.countPedidosPorFormaPagamento();
        List<PedidosPorFormaPagamento> pedidosPorFormaPagamentoList = new ArrayList<>();

        for (Object[] result : results) {
            String formaPagamento = (String) result[0];
            Long quantidadePedidos = (Long) result[1];
            pedidosPorFormaPagamentoList.add(new PedidosPorFormaPagamento(formaPagamento, quantidadePedidos));
        }

        return pedidosPorFormaPagamentoList;
    }

    @GetMapping("/pedidos-por-cliente")
    public List<Object[]> contarPedidosPorCliente() {
        return pedidoService.contarPedidosPorCliente();
    }


}
