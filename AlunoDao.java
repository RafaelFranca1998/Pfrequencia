package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.Usuario;

public class AlunoDao {

	private DataSource dataSource;
	public Connection connection;
	public PreparedStatement stmt;

	// -------------------------------------------------------------------
	public AlunoDao(DataSource datasource) {
		this.dataSource = datasource;
	}

	// -------------------------------------------------------------------
	public ArrayList<Usuario> listarAluno() {
		try {
			String SQL = "select * from tbteste1";
			PreparedStatement ps = dataSource.getConnection().prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			ArrayList<Usuario> Lista = new ArrayList<Usuario>();
			while (rs.next()) {
				Usuario aluno = new Usuario();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setFrequencia(rs.getInt("frequencia"));
				Lista.add(aluno);
			}
			ps.close();
			return Lista;
		} catch (SQLException e) {
			System.err.println("Erro na Listagem " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Erro Geral " + e.getMessage());
		}
		return null;
	}

	// -------------------------------------------------------------------
	public void create(Usuario A) {
		Connection con = dataSource.getConnection();
		PreparedStatement stmp = null;
		try {
			stmp = con.prepareStatement("insert into tbteste1(id,nome,email,frequencia) values (?,?,?,?)");
			stmp.setInt(1, A.getId());
			stmp.setString(2, A.getNome());
			stmp.setString(3, A.getEmail());
			stmp.setInt(4, A.getFrequencia());
			stmp.executeUpdate();
			System.out.println("Sucesso!");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// -------------------------------------------------------------------
	
//	public ArrayList<Aluno> read() {
//		Connection con = dataSource.getConnection();
//		PreparedStatement stmp = null;
//		ResultSet rs = null ;
//		try {
//			stmp = con.prepareStatement("SELECT * FROM tbteste1 ");
//			rs = stmp.executeQuery();
//			while (rs.next()) {
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//		
//	}
	
	// -------------------------------------------------------------------

	public void delete(Usuario A) {
		Connection con = dataSource.getConnection();
		PreparedStatement stmp = null;
		try {
			stmp = con.prepareStatement("DELETE FROM tbteste1 WHERE id= ?");
			stmp.setInt(1, A.getId());
			stmp.executeUpdate();
			System.out.println("Sucesso!");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
