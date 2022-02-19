package com.questao01.utilitario;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.questao01.modelo.dao.DaoFactory;
import com.questao01.modelo.dao.ProdutoDao;
import com.questao01.modelo.entidades.Produto;

public class Menu {
	
	public static void menu() {
		System.out.println("-------CADASTRO DE OFERTAS DE PRODUTOS--------------");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - para INSERIR uma oferta");
		System.out.println("2 - para ATUALIZ uma oferta");
		System.out.println("3 - para DELETAR uma oferta");
		System.out.println("4 - para listar as palavras que contém?");
		System.out.println("5 - para BUSCA uma oferta especifica");
		System.out.println("6 - para listar TODAS as ofertas");
		System.out.println("7 - para SAIR");
		System.out.println("-----------------------------------------------------");
	}
	
	public static void salvar() throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		System.out.println("Digite o nome do produto: ");
		String nome = sc.nextLine();
		System.out.println("Digite a descrição do produto: ");
		String descricao = sc.nextLine();
		System.out.println("Digite o valor do desconto: ");
		Double desconto = sc.nextDouble();
		System.out.println("Digite a data da oferta: ");
		String dataString = sc.next();
		Date data = (Date) sdf.parse(dataString);
		
		Produto produto = new Produto(null, nome, descricao, desconto, data);
		
		produtoDao.salvar(produto);
		
		
		
	}
	
	public static void atualizar() {
		
	}
	
	public static void deletar() {
		
	}
	
	public static void buscaContendo() {
		
	}
	
	public static void buscaPorId() {
		
	}
	
	public static void buscaTodos() {
		
	}

}
