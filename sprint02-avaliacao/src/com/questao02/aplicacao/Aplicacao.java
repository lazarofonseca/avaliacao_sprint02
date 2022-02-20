package com.questao02.aplicacao;

import java.util.Scanner;

import com.questao02.controller.VerificaSentimento;

public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entrada: ");
		String entrada = sc.nextLine();
		
		
		int divertido = VerificaSentimento.divertido(entrada);
		int chateado = VerificaSentimento.chateaco(entrada);
		String sentimento;
		
		if(divertido == chateado) {
			sentimento = "neutro";
		}else if(divertido > chateado) {
			sentimento = "divertido";
		}else {
			sentimento = "chateado";
		}
		
		System.out.println("Saída: " + sentimento);

	}

}
