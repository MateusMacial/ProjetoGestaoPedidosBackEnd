package com.mateusmacial.projetogestaodepedidos.domain;

import java.io.Serializable;

public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String codigoProduto;
	private String descricaoProduto;
	
	public Produto() {
		
	}
	public Produto(Integer id, String codigoProduto, String descricaoProduto) {
		super();
		this.id = id;
		this.codigoProduto = codigoProduto;
		this.descricaoProduto = descricaoProduto;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
