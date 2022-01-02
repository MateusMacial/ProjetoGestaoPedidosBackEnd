package com.mateusmacial.projetogestaodepedidos.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmacial.projetogestaodepedidos.domain.Pedido;
import com.mateusmacial.projetogestaodepedidos.domain.Produto;
import com.mateusmacial.projetogestaodepedidos.dto.PedidoDTO;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.services.PedidoService;
import com.mateusmacial.projetogestaodepedidos.services.ProdutoService;

@RestController
@CrossOrigin
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired 
	private PedidoService pedidoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ResponseEntity<?> find(Integer id) {		
		Pedido obj = pedidoService.find(id);				
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Pedido insert(@Valid @RequestBody PedidoDTO objDto){
		Pedido pedido = pedidoService.fromDTO(objDto);
		for (ProdutoDTO produtoDto : objDto.getProdutosDoPedido()) {
			Produto produto = produtoService.find(produtoDto.getId());
			pedidoService.insertProduto(pedido, produto);
		}
		pedido = pedidoService.insert(pedido);
		return pedido;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Void> update(@Valid @RequestBody PedidoDTO objDto){
		Pedido obj = pedidoService.fromDTO(objDto);
		obj = pedidoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(Integer id){
		Pedido pedido = pedidoService.find(id);
		for (Produto produto : pedido.getProdutosDoPedido()) {
			produto.setPedido(null);
		}
		pedido.setProdutosDoPedido(null);
		pedidoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> findAll() {		
		List<Pedido> list = pedidoService.findAll();		
		List<PedidoDTO> listDto = list.stream()
				.map(obj -> new PedidoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	
}
