package com.mateusmacial.projetogestaodepedidos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mateusmacial.projetogestaodepedidos.domain.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codigoPedido;
	private String cliente;
	private Date dataEntrega;
	private String observacao;
	
	private List<ProdutoDTO> produtosDoPedido = new ArrayList<>();
	
	public PedidoDTO() {
		
	}
	public PedidoDTO(Pedido obj) {
		this.id = obj.getId();
		this.codigoPedido = obj.getCodigoPedido();
		this.cliente = obj.getCliente();
		this.dataEntrega = obj.getDataEntrega();
		this.observacao = obj.getObservacao();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public List<ProdutoDTO> getProdutosDoPedido() {
		return produtosDoPedido;
	}
	public void setProdutosDoPedido(List<ProdutoDTO> produtosDoPedido) {
		this.produtosDoPedido = produtosDoPedido;
	}
}
