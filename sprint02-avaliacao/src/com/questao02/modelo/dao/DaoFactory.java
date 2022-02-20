package com.questao02.modelo.dao;

import com.questao02.db.DB2;
import com.questao02.modelo.dao.impl.SentimentoDaoJDBC;

public class DaoFactory {
	
	public static SentimentoDao createSentimentoDao() {
		return new SentimentoDaoJDBC(DB2.getConnection());
	}

}
