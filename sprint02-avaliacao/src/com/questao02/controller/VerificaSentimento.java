package com.questao02.controller;

public class VerificaSentimento {

	public static int divertido(String entrada) {

		int pos = -1;
		int divertido = 0;
		int chateado = 0;

		while (true) {

			pos = entrada.indexOf(":-)", pos + 1);
			if (pos < 0)
				break;
			divertido++;

		}
		return divertido;
	}

	public static int chateaco(String entrada) {

		int pos = -1;
		int divertido = 0;
		int chateado = 0;

		while (true) {

			pos = entrada.indexOf(":-(", pos + 1);
			if (pos < 0)
				break;
			chateado++;

		}
		return chateado;
	}
	

}
