package com.mateusmacial.projetogestaodepedidos.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateusmacial.projetogestaodepedidos.domain.Pedido;
import com.mateusmacial.projetogestaodepedidos.dto.PedidoDTO;
import com.mateusmacial.projetogestaodepedidos.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired 
	private PedidoService pedidoService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ResponseEntity<?> find(Integer id) {		
		Pedido obj = pedidoService.find(id);				
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PedidoDTO objDto){ 
		Pedido obj = pedidoService.fromDTO(objDto);
		obj = pedidoService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				//.path("/{id}")
				.path("/id")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PedidoDTO objDto, Integer id){		
		Pedido obj = pedidoService.fromDTO(objDto);
		obj.setId(id);
		obj = pedidoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(Integer id){
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
