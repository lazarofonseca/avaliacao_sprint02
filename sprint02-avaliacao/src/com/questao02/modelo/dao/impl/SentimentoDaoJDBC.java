package com.questao02.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.questao01.db.DB;
import com.questao01.db.DbException;
import com.questao01.modelo.entidades.Produto;
import com.questao02.modelo.Sentimento;
import com.questao02.modelo.dao.SentimentoDao;

public class SentimentoDaoJDBC implements SentimentoDao{
	
	private Connection conn;
	
	public SentimentoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void salvar(String sentimento) {
		
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			pst = conn.prepareStatement(
					"INSERT INTO sentimento" + "(status)" + " VALUES " + "(?)");

			pst.setString(1, sentimento);
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}
		
		
	}

	@Override
	public List<Sentimento> buscar() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM sentimento");
			rs = st.executeQuery();

			List<Sentimento> listaSentimentos = new ArrayList<>();

			while (rs.next()) {
				Sentimento sentimento = criaSentimento(rs);
				sentimento.setId(rs.getInt("id"));
				sentimento.setStatus(rs.getString("status"));
				
			
				
				listaSentimentos.add(sentimento);
			}
			return listaSentimentos;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}
	
	private Sentimento criaSentimento(ResultSet rs) throws SQLException {

		Sentimento sentimento = new Sentimento();
		sentimento.setId(rs.getInt("id"));
		sentimento.setStatus(rs.getString("status"));
		
		return sentimento;
	}

}
