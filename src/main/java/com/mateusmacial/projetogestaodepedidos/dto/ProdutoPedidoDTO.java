package com.mateusmacial.projetogestaodepedidos.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoPedidoDTO {
	
	private Long id;
	private Long produtoId;
	private Long pedidoId;
}
