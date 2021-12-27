package com.mateusmacial.projetogestaodepedidos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmacial.projetogestaodepedidos.domain.Produto;
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
}
