package com.mateusmacial.projetogestaodepedidos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateusmacial.projetogestaodepedidos.entidades.Pedido;

@Repository
public interface PedidoDao extends JpaRepository<Pedido, Long> {

}
