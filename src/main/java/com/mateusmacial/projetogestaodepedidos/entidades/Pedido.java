package com.mateusmacial.projetogestaodepedidos.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String codigoPedido;
	private String cliente;
	private Date dataEntrega;
	private String observacao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", orphanRemoval = true)
	private List<ProdutoPedido> produtosDoPedido = new ArrayList<>();	
}