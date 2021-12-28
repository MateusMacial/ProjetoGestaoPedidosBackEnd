package com.mateusmacial.projetogestaodepedidos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mateusmacial.projetogestaodepedidos.domain.Pedido;
import com.mateusmacial.projetogestaodepedidos.domain.Produto;
import com.mateusmacial.projetogestaodepedidos.repositories.PedidoRepository;
import com.mateusmacial.projetogestaodepedidos.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetogestaodepedidosApplication implements CommandLineRunner {

	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetogestaodepedidosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pedido ped1 = new Pedido(null, "3356", "Mateus", sdf.parse("30/09/2017"), "OK");
		Pedido ped2 = new Pedido(null, "909", "Mario", sdf.parse("20/12/2021"), "Aguardando confirmação");
		
		Produto prod1 = new Produto(null, "414", "Banana");
		Produto prod2 = new Produto(null, "76789", "Batata");
		Produto prod3 = new Produto(null, "455", "Maça");
		
		//ped1.getProdutos().addAll(Arrays.asList(prod1, prod2));
		//ped2.getProdutos().addAll(Arrays.asList(prod3));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));
	}
}
