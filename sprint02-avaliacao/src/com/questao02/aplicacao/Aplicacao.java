package com.questao02.aplicacao;

import java.util.List;
import java.util.Scanner;

import com.questao02.controller.VerificaSentimento;
import com.questao02.modelo.Sentimento;
import com.questao02.modelo.dao.DaoFactory;
import com.questao02.modelo.dao.SentimentoDao;

public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entrada: ");
		String entrada = sc.nextLine();
		
		
		int divertido = VerificaSentimento.divertido(entrada);
		int chateado = VerificaSentimento.chateaco(entrada);
		String sentimento;
		SentimentoDao objDao = DaoFactory.createSentimentoDao();
		
		if(divertido == chateado) {
			sentimento = "neutro";
		}else if(divertido > chateado) {
			sentimento = "divertido";
		}else {
			sentimento = "chateado";
		}
		
		System.out.println("Saída: " + sentimento);
		objDao.salvar(sentimento);
		List<Sentimento> lista = objDao.buscar();
		System.out.println();
		System.out.println();
		System.out.println("--------------Saída-------------------");
		for(Sentimento sent : lista) {
			System.out.println("Id: " + sent.getId());
			System.out.println("Status: " + sent.getStatus());
		}

	}

}
