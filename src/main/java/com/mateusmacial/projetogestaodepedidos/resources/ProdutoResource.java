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
				.path("/id")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProdutoDTO objDto, Integer id){		
		Produto obj = produtoService.fromDTO(objDto);
		obj.setId(id);
		obj = produtoService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(Integer id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> findAll() {		
		List<Produto> list = produtoService.findAll();		
		List<ProdutoDTO> listDto = list.stream()
				.map(obj -> new ProdutoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
