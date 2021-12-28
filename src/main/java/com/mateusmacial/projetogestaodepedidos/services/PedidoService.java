package com.mateusmacial.projetogestaodepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.projetogestaodepedidos.domain.Pedido;
import com.mateusmacial.projetogestaodepedidos.dto.PedidoDTO;
import com.mateusmacial.projetogestaodepedidos.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired 
	private PedidoRepository pedidoRepository;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = pedidoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		return pedidoRepository.save(obj);
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
	}
}
