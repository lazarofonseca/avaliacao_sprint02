package com.questao01.utilitario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.questao01.modelo.dao.DaoFactory;
import com.questao01.modelo.dao.ProdutoDao;
import com.questao01.modelo.entidades.Produto;

public class Utilitario {
	
	public static void geraOfertas() {
	
	Produto produto1 = new Produto(null, "Smart TV", "Full Hd wifi", 300.0, new Date());
	Produto produto2 = new Produto(null, "Smart Fhone", "Motorola E7", 100.0, new Date());
	Produto produto3 = new Produto(null, "Fritadeira", "Fritadeira sem óleo", 100.0, new Date());
	Produto produto4 = new Produto(null, "Guarda Roupa", "Bartiria fortaleza II", 400.0, new Date());
	Produto produto5 = new Produto(null, "Iphone", "Apple 64GB branco", 350.0, new Date());
	Produto produto6 = new Produto(null, "Refrigerador", "Duplex DC35A 260L", 500.0, new Date());
	Produto produto7 = new Produto(null, "Lavadoura de Roupas", "Consul com ciclo Edredom", 45000.0, new Date());
	Produto produto8 = new Produto(null, "Sofá", "Três lugares", 200.0, new Date());
	Produto produto9 = new Produto(null, "Rack", "1,36 Madetec Lisboa para TV", 250.0, new Date());
	Produto produto10 = new Produto(null, "Cozinha", "Cozinha completa Emily preto", 650.0, new Date());
	
	ProdutoDao produtoDao = DaoFactory.createProdutoDao();
	
	List<Produto> lista = new ArrayList<Produto>();
	lista.add(produto1);
	lista.add(produto2);
	lista.add(produto3);
	lista.add(produto4);
	lista.add(produto5);
	lista.add(produto6);
	lista.add(produto7);
	lista.add(produto8);
	lista.add(produto9);
	lista.add(produto10);
	
	
	
	Random random = new Random(lista.size());
	for(int i = 0; i < 3; i++) {
		int gerador = (int) (Math.random() * 10);
		Produto produto = lista.get(gerador);
		produtoDao.salvar(produto);
	}

	
	}
}
