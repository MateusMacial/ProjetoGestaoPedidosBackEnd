package com.mateusmacial.projetogestaodepedidos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateusmacial.projetogestaodepedidos.entidades.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Long> {

}
