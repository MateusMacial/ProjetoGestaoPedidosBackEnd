package com.mateusmacial.projetogestaodepedidos.dao;

import com.mateusmacial.projetogestaodepedidos.entidades.ProdutoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoDao extends JpaRepository<ProdutoPedido, Long> {

}
