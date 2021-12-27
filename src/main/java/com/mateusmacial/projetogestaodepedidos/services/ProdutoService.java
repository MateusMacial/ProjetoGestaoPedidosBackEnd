package com.mateusmacial.projetogestaodepedidos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.projetogestaodepedidos.domain.Produto;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return produtoRepository.save(obj);
	}
	
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return produtoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		produtoRepository.deleteById(id);
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getCodigoProduto(), objDto.getDescricaoProduto());
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setCodigoProduto(obj.getCodigoProduto());
		newObj.setDescricaoProduto(obj.getDescricaoProduto());
	}
}
