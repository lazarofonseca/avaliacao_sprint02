package com.questao01.aplicacao;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.imageio.IIOParam;

import com.questao01.aplicacao.db.exception.DbExceptionEnterInvalid;
import com.questao01.modelo.dao.DaoFactory;
import com.questao01.modelo.dao.ProdutoDao;
import com.questao01.modelo.entidades.Produto;
import com.questao01.utilitario.Menu;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {

		/*
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		 * 
		 * Produto produtoSalvo = new Produto(null, "Celular", "Celular Sansumg", 200.0,
		 * new Date());
		 * 
		 * produtoDao.salvar(produtoSalvo);
		 * 
		 * 
		 * Produto produtoBuscado = produtoDao.buscaPorId(1);
		 * 
		 * produtoSalvo = produtoDao.buscaPorId(2);
		 * 
		 * produtoSalvo.setNome("SmartFone");
		 * produtoSalvo.setDescricao("SmartFone 14 polegadas");
		 * produtoDao.atualizar(produtoSalvo);
		 * 
		 * 
		 * System.out.println("Digite o id do produto a ser deletado: "); int id =
		 * sc.nextInt();
		 * 
		 * produtoDao.delete(id);
		 * 
		 * 
		 * List<Produto> produtos = produtoDao.buscar();
		 * 
		 * for (Produto prod : produtos) { System.out.println(prod); }
		 */
		
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			Menu.menu();
			
			opcao = sc.nextInt();
	
			
			if(opcao == 1) {
				Menu.salvar();
			}else if(opcao == 2) {
				Menu.atualizar();
			}else if(opcao == 3) {
				Menu.deletar();
			}else if(opcao == 4) {
				Menu.buscaContendo();
			}else if(opcao == 5) {
				Menu.buscaPorId();
			}else if(opcao == 6) {
				Menu.buscaTodos();
			}else if(opcao > 0 || opcao < 0){
				System.out.println("Opção inválida:");
			}
			
		}while(opcao != 0);
		
		System.out.println("------------Sistema encerrado---------------");

	}

}
