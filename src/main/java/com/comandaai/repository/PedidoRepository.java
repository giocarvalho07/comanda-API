package com.comandaai.repository;

import com.comandaai.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("SELECT MONTH(p.data_pedido) as mes, COUNT(p) as totalPedidos FROM Pedido p GROUP BY mes")
    List<Object[]> getTotalPedidosPorMes();

    @Query("SELECT p.forma_pagamento.nome_pagamento, COUNT(p) FROM Pedido p GROUP BY p.forma_pagamento.nome_pagamento")
    List<Object[]> countPedidosPorFormaPagamento();

    @Query("SELECT c.nome_cliente, COUNT(p.id_pedido) " +
            "FROM Pedido p " +
            "JOIN p.clientes c " +
            "GROUP BY c.nome_cliente")
    List<Object[]> countPedidosPorCliente();

}
