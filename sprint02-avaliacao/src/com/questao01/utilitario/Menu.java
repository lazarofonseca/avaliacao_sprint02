package com.questao01.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
		
		System.out.println("");
		
	}
	
	public static void atualizar() throws ParseException{
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		System.out.println("Digite i ID do produto a ser atualizado: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		Produto produto = new Produto();
		produto = produtoDao.buscaPorId(id); // Busca o produto a ser atualizado
		
		System.out.println("Digite o nome do produto: ");
		String nome = sc.nextLine();
		produto.setNome(nome);
		System.out.println("Digite a descrição do produto: ");
		String descricao = sc.nextLine();
		produto.setDescricao(descricao);
		System.out.println("Digite o valor do desconto: ");
		Double desconto = sc.nextDouble();
		produto.setDesconto(desconto);
		System.out.println("Digite a data da oferta: ");
		String dataString = sc.next();
		Date data = (Date) sdf.parse(dataString);
		produto.setDataInicio(data);
		
		produtoDao.atualizar(produto);
		System.out.println("");
		
	}
	
	public static void deletar() {
		
		Scanner sc = new Scanner(System.in);
		
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		System.out.println("Digite o ID do produto a ser deletado: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		produtoDao.delete(id);
		System.out.println("");
		
	}
	
	public static void buscaContendo() {
		
	}
	
	public static void buscaPorId() {
		
		Scanner sc = new Scanner(System.in);
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		
		System.out.println("Digite o ID do produto a ser buscado: ");
		int id = sc.nextInt();
		sc.nextLine();
		Produto produto = new Produto();
		
		produto = produtoDao.buscaPorId(id);
		System.out.println("----PRODUTO----");
		System.out.println(produto);
		System.out.println("");
		
	}
	
	public static void buscaTodos() {
		
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		List<Produto> ListaProdutos = produtoDao.buscar();
		
		System.out.println("------LISTA DE OFERTAS DE PRODUTOS-------");
		for(Produto prod : ListaProdutos) {
			System.out.println(prod);
			System.out.println();
		}
		
	}

}
