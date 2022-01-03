package com.mateusmacial.projetogestaodepedidos.entidades;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProdutoPedido extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;
}