package com.questao01.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.questao01.db.DB;
import com.questao01.db.DbException;
import com.questao01.modelo.dao.ProdutoDao;
import com.questao01.modelo.entidades.Produto;

public class ProdutoDaoJDBC implements ProdutoDao {

	private Connection conn;

	public ProdutoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void salvar(Produto produto) {

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			pst = conn.prepareStatement(
					"INSERT INTO produto" + "(nome, descricao, desconto, data_inicio)" + " VALUES " + "(?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getDesconto());
			pst.setDate(4, new java.sql.Date(produto.getDataInicio().getTime()));

			int linhasAfetadas = pst.executeUpdate();

			if (linhasAfetadas > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					produto.setId(id);
				}
			} else {
				throw new DbException("Erro ao inserir o registro");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}

	}

	@Override
	public void atualizar(Produto produto) {
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			pst = conn.prepareStatement(
					"UPDATE produto " + "SET nome = ?, descricao = ?, desconto = ?, data_inicio = ?" + "WHERE id = ?");

			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getDesconto());
			pst.setDate(4, new java.sql.Date(produto.getDataInicio().getTime()));
			pst.setInt(5, produto.getId());

			pst.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}

	}

	@Override
	public void delete(Integer id) {

		PreparedStatement pst = null;
		try {

			pst = conn.prepareStatement("DELETE FROM produto WHERE id = ?");

			pst.setInt(1, id);

			int linhasAfetadas = pst.executeUpdate();
			try {
				if (linhasAfetadas == 0) {
					throw new DbException("Id não encontrado");
				}
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
		}

	}

	@Override
	public Produto buscaPorId(Integer id) {

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {

			pst = conn.prepareStatement("SELECT * FROM produto WHERE Id = ?");

			pst.setInt(1, id);
			rs = pst.executeQuery();
			if (rs.next()) {
				Produto produto = criaProduto(rs);

				return produto;

			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
		}

	}

	private Produto criaProduto(ResultSet rs) throws SQLException {

		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setDesconto(rs.getDouble("desconto"));
		produto.setDataInicio(rs.getDate("data_inicio"));

		return produto;
	}

	@Override
	public List<Produto> buscar() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM produto");
			rs = st.executeQuery();

			List<Produto> listaProdutos = new ArrayList<>();

			while (rs.next()) {
				Produto produto = criaProduto(rs);
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDesconto(rs.getDouble("desconto"));
				produto.setDataInicio(rs.getDate("data_inicio"));
				listaProdutos.add(produto);
			}
			return listaProdutos;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Produto> buscaContendo(String entrada) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("SELECT * FROM produto WHERE nome LIKE "
					+ "?");
			
			List<Produto> listaProdutos = new ArrayList<>();
			pst.setString(1, '%' +entrada + '%');
			rs = pst.executeQuery();
			while(rs.next()) {
				Produto produto = criaProduto(rs);
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setDesconto(rs.getDouble("desconto"));
				produto.setDataInicio(rs.getDate("data_inicio"));
				listaProdutos.add(produto);
			}

			return listaProdutos;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(pst);
			DB.closeResultSet(rs);
		}
	}

}
