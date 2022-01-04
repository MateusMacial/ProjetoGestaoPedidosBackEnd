package com.mateusmacial.projetogestaodepedidos.entidades;

import java.util.ArrayList;
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

public class Produto extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String codigoProduto;
	private String descricaoProduto;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
	private List<ProdutoPedido> pedidosDoProduto = new ArrayList<>();
}
