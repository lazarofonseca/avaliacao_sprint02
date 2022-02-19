package com.questao01.modelo.dao;

import com.questao01.db.DB;
import com.questao01.modelo.dao.impl.ProdutoDaoJDBC;

public class DaoFactory {
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}

}
