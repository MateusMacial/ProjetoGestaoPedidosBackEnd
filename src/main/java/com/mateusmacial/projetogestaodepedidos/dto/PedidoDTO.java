package com.mateusmacial.projetogestaodepedidos.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDTO {

	private Integer id;
	private String codigoPedido;
	private String cliente;
	private Date dataEntrega;
	private String observacao;
	
	private List<ProdutoPedidoDTO> produtosDoPedido;
}
