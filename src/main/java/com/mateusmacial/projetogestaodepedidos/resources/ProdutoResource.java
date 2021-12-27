package com.mateusmacial.projetogestaodepedidos.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateusmacial.projetogestaodepedidos.domain.Produto;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> listar() {
		
		Produto prod1 = new Produto(1, "1343", "Banana");
		Produto prod2 = new Produto(2, "78678", "Batata");
		
		List<Produto> lista = new ArrayList<>();
		
		lista.add(prod1);
		lista.add(prod2);
		
		return lista;
	}
}
