package com.mateusmacial.projetogestaodepedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateusmacial.projetogestaodepedidos.dao.ProdutoDao;
import com.mateusmacial.projetogestaodepedidos.dto.ProdutoDTO;
import com.mateusmacial.projetogestaodepedidos.entidades.Produto;

// import org.apache.commons.lang3.StringUtils;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoDao produtoDao;

	private Produto find(long id) {
		Optional<Produto> obj = produtoDao.findById(id);
		return obj.orElse(null);
	}

	public Produto save(ProdutoDTO produtoDto) {
		Produto produto;

		if(produtoDto.getId() > 0) {
			produto = produtoDao.getById(produtoDto.getId());
		}
		else {
			produto = new Produto();
		}
		/*if(StringUtils.isBlank(produtoDto.getCodigoProduto())) {
			//ToDo
		}
		if(StringUtils.isBlank(produtoDto.getDescricaoProduto())) {
			//ToDo
		}*/

		produto.setCodigoProduto(produtoDto.getCodigoProduto());
		produto.setDescricaoProduto(produtoDto.getDescricaoProduto());

		return produtoDao.save(produto);
	}

	/*public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return produtoDao.save(newObj);
	}*/

	public void delete(long id) {
		find(id);
		produtoDao.deleteById(id);
	}

	public List<Produto> findAll(){
		return produtoDao.findAll();
	}

	/*public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getCodigoProduto(), objDto.getDescricaoProduto());
	}*/

	/*private void updateData(Produto newObj, Produto obj) {
		newObj.setCodigoProduto(obj.getCodigoProduto());
		newObj.setDescricaoProduto(obj.getDescricaoProduto());
	}*/
}
