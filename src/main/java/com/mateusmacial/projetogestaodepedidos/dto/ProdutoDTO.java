package com.mateusmacial.projetogestaodepedidos.dto;

import java.io.Serializable;

import com.mateusmacial.projetogestaodepedidos.domain.Pedido;
import com.mateusmacial.projetogestaodepedidos.domain.Produto;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codigoProduto;
	private String descricaoProduto;
	private Pedido pedido;
	
	public ProdutoDTO() {
		
	}
	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.codigoProduto = obj.getCodigoProduto();
		this.descricaoProduto = obj.getDescricaoProduto();
		this.setPedido(obj.getPedido());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
