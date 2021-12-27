package com.mateusmacial.projetogestaodepedidos.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateusmacial.projetogestaodepedidos.domain.Produto;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.services.ProdutoService;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@Autowired 
	private ProdutoService produtoService;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ResponseEntity<?> find(Integer id) {		
		Produto obj = produtoService.find(id);				
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoDTO objDto){ 
		Produto obj = produtoService.fromDTO(objDto);
		obj = produtoService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				//.path("/{id}")
				.path("/id")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
}
