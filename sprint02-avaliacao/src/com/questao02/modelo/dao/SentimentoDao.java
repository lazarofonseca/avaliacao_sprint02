package com.questao02.modelo.dao;

import java.util.List;

import com.questao02.modelo.Sentimento;

public interface SentimentoDao {
	
	void salvar(String sentimento);
	List<Sentimento> buscar();

}
