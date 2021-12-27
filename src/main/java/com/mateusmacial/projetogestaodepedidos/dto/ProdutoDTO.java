package com.mateusmacial.projetogestaodepedidos.dto;

import com.mateusmacial.projetogestaodepedidos.domain.Produto;

public class ProdutoDTO {

	private Integer id;
	private String codigoProduto;
	private String descricaoProduto;
	
	public ProdutoDTO() {
		
	}
	public ProdutoDTO(Produto obj) {
		this.id = obj.getId();
		this.codigoProduto = obj.getCodigoProduto();
		this.descricaoProduto = obj.getDescricaoProduto();
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
	
}
