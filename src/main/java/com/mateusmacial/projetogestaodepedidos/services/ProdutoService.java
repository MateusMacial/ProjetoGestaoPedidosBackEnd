package com.mateusmacial.projetogestaodepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.projetogestaodepedidos.dao.ProdutoDao;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.entidades.Produto;

import antlr.StringUtils;

@Service
public class ProdutoService {
	
	@Autowired 
	private ProdutoDao produtoDao;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.orElse(null);
	}
	
	public Produto save(ProdutoDTO objDto) {
		if(objDto == null) {
			//ToDo
		}
		Produto produto;
		if(objDto.getId() > 0) {
			produto = produtoDao.findById(objDto.getId());
		}
		else {
			produto = new Produto();
		}
		
		if(StringUtils.isBlank(objDto.getCodigoProduto())) {
			//ToDo
		}
		if(StringUtils.isBlank(objDto.getDescricaoProduto())) {
			//ToDo
		}
		
		produto.setCodigoProduto(objDto.getCodigoProduto());
		produto.setDescricaoProduto(objDto.getDescricaoProduto());
		
		produtoDao.save(produto);
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
	
	public List<Produto> findAll(){
		return produtoRepository.findAll();
	}
	
	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getCodigoProduto(), objDto.getDescricaoProduto(), objDto.getPedido());
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setCodigoProduto(obj.getCodigoProduto());
		newObj.setDescricaoProduto(obj.getDescricaoProduto());
	}
}
