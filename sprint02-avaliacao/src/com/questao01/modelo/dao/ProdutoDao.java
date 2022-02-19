package com.questao01.modelo.dao;

import java.util.List;

import com.questao01.modelo.entidades.Produto;

public interface ProdutoDao {
	
	void salvar(Produto produto);
	void atualizar(Produto produto);
	void delete(Integer id);
	Produto buscaPorId(Integer id);
	List<Produto> buscar();
	List<Produto> buscaContendo(Produto produto, String entrada);
	

}
