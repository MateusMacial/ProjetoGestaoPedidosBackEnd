package com.mateusmacial.projetogestaodepedidos.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmacial.projetogestaodepedidos.dto.PedidoDTO;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.entidades.Pedido;
import com.mateusmacial.projetogestaodepedidos.entidades.Produto;
import com.mateusmacial.projetogestaodepedidos.services.PedidoService;
import com.mateusmacial.projetogestaodepedidos.services.ProdutoService;

@RestController
@Transactional
@RequestMapping(value="/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ResponseEntity<?> find(Integer id) {
		Pedido obj = pedidoService.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public void save(@Valid @RequestBody PedidoDTO pedidoDto){
		pedidoService.save(pedidoDto);
	}

	/*@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Void> update(@Valid @RequestBody PedidoDTO objDto){
		Pedido pedido = pedidoService.fromDTO(objDto);
		for (ProdutoDTO produtoDto : objDto.getProdutosDoPedido()) {
			Produto produto = produtoService.find(produtoDto.getId());
			pedidoService.insertProduto(pedido, produto);
		}
		pedido = pedidoService.update(pedido);
		return ResponseEntity.noContent().build();
	}*/

	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(Integer id){
		Pedido pedido = pedidoService.find(id);
		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/get-page", method=RequestMethod.GET)
	public List<PedidoDTO> findAll() {
		ModelMapper modelMapper = new ModelMapper();
		List<Pedido> list = pedidoService.findAll();
		return list.stream()
				.map(obj -> modelMapper.map(obj, PedidoDTO.class))
				.collect(Collectors.toList());
	}
}
