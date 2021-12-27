package com.mateusmacial.projetogestaodepedidos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateusmacial.projetogestaodepedidos.domain.Produto;
import com.mateusmacial.projetogestaodepedidos.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetogestaodepedidosApplication implements CommandLineRunner {

	@Autowired 
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetogestaodepedidosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Produto prod1 = new Produto(null, "414", "Banana");
		Produto prod2 = new Produto(null, "76789", "Batata");
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
	}
}
