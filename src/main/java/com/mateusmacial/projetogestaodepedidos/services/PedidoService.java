package com.mateusmacial.projetogestaodepedidos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.projetogestaodepedidos.dao.PedidoDao;
import com.mateusmacial.projetogestaodepedidos.dao.ProdutoDao;
import com.mateusmacial.projetogestaodepedidos.dto.PedidoDTO;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoPedidoDTO;
import com.mateusmacial.projetogestaodepedidos.entidades.Pedido;
import com.mateusmacial.projetogestaodepedidos.entidades.Produto;
import com.mateusmacial.projetogestaodepedidos.entidades.ProdutoPedido;

import antlr.StringUtils;

@Service
public class PedidoService {
	
	@Autowired 
	private PedidoDao pedidoDao;
	
	@Autowired
	private ProdutoDao produtoDao;
		
	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Pedido insert(PedidoDTO objDto) {
		if(objDto == null) {
			//ToDo
		}
		Pedido pedido;
		if(objDto.getId() > 0) {
			pedido = pedidoDao.findById(objDto.getId());
		}
		else {
			pedido = new Pedido();
		}
		
		if(StringUtils.isBlank(objDto.getCodigoPedido())) {
			//ToDo
		}
		if(StringUtils.isBlank(objDto.getCliente())) {
			//ToDo
		}
		if(objDto.getDataEntrega() == null) {
			//ToDo
		}
		if(objDto.getProdutosDoPedido() == null) {
			//ToDO
		}
		
		pedido.setCodigoPedido(objDto.getCodigoPedido());
		pedido.setCliente(objDto.getCliente());
		pedido.setDataEntrega(objDto.getDataEntrega());
		
		if(pedido.getProdutosDoPedido() == null) {
			pedido.setProdutosDoPedido(new ArrayList<>());
		}
		pedido.getProdutosDoPedido().clear();
		
		for (ProdutoPedidoDTO produtoPedidoDTO : objDto.getProdutosDoPedido()) {
			
			ProdutoPedido produtoPedido;
			
			if(produtoPedidoDTO.getId() > 0) {
				produtoPedido = produtoDao.findById(produtoPedidoDTO.getId());
			}
			else {
				produtoPedido = new ProdutoPedido();
			}
			
			Produto produto = produtoDao.findById(produtoPedidoDTO.getProdutoId());
			
			produtoPedido.setPedido(pedido);
			produtoPedido.setProdutoId(produto);
			
			pedido.getProdutosDoPedido().add(produtoPedido);
		}
		
		pedidoDao.save(pedido);
	}
	
	public Pedido update(Pedido obj) {
		Pedido newObj = find(obj.getId());
		updateData(newObj, obj);
		return pedidoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		pedidoRepository.deleteById(id);
	}
	
	public void insertProduto(Pedido pedido, Produto produtoInserir) {
		pedido.adicionarProduto(produtoInserir);
		produtoInserir.setPedido(pedido);
	}
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido fromDTO(PedidoDTO objDto) {
		return new Pedido(objDto.getId(), objDto.getCodigoPedido(), objDto.getCliente(), objDto.getDataEntrega(), objDto.getObservacao());
	}
	
	private void updateData(Pedido newObj, Pedido obj) {
		newObj.setCodigoPedido(obj.getCodigoPedido());
		newObj.setCliente(obj.getCliente());
		newObj.setDataEntrega(obj.getDataEntrega());
		newObj.setObservacao(obj.getObservacao());
		
		for (Produto produto : newObj.getProdutosDoPedido()) {
			produto.setPedido(null);
		}
		
		newObj.getProdutosDoPedido().clear();
		
		for (Produto produto : obj.getProdutosDoPedido()) {
			produto.setPedido(newObj);
			newObj.adicionarProduto(produto);
		}
	}
}
