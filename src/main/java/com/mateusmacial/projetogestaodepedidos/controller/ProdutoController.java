package com.mateusmacial.projetogestaodepedidos.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.entidades.Produto;
import com.mateusmacial.projetogestaodepedidos.services.ProdutoService;

@RestController
@Transactional
@RequestMapping(value="/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public void save(@Valid @RequestBody ProdutoDTO produtoDto){
		produtoService.save(produtoDto);
	}

	/*@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Void> update(@Valid @RequestBody ProdutoDTO objDto){
		Produto obj = produtoService.fromDTO(objDto);
		obj = produtoService.update(obj);
		return ResponseEntity.noContent().build();
	}*/

	@RequestMapping(value="/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(Integer id){
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/get-page",method=RequestMethod.GET)
	public List<ProdutoDTO> findAll() {
		ModelMapper modelMapper = new ModelMapper();
		List<Produto> list = produtoService.findAll();
		return list.stream()
				.map(obj -> modelMapper.map(obj, ProdutoDTO.class))
				.collect(Collectors.toList());
	}
}
