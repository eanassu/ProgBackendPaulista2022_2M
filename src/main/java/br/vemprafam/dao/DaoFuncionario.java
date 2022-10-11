package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import br.vemprafam.pojo.Funcionario;

public class DaoFuncionario {

	private Connection connection;
	
	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";
	
	public DaoFuncionario() {
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void inserirFuncionario( Funcionario funcionario ) {
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO FUNCIONARIOS VALUES(?,?,?,?,?)");
			pstmt.setInt(1, funcionario.getRe());
			pstmt.setString(2, funcionario.getNome());
			pstmt.setDate(3, 
			new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(4, funcionario.getSalario());
			pstmt.setString(5, funcionario.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	public List<Funcionario> getLista() {
		List<Funcionario> result = new ArrayList<Funcionario>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM FUNCIONARIOS");
			ResultSet rs = pstmt.executeQuery();
			while( rs.next() ) {
				result.add(new Funcionario(rs.getInt(1),
						                   rs.getString(2), 
						                   rs.getDate(3), 
						                   rs.getDouble(4),
						                   rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
		
		return result;
	}
	
	public static void main(String[] args) {
		DaoFuncionario dao = new DaoFuncionario();
		List<Funcionario> lista = dao.getLista();
		for( Funcionario f: lista ) {
			
			System.out.println(f);
		}
	}

	public void excluirFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"DELETE FROM FUNCIONARIOS WHERE RE=?");
			pstmt.setInt(1, funcionario.getRe());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 	
	}
	
	public Funcionario buscarPeloRe( int re ) {
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM FUNCIONARIOS WHERE RE=?");
			pstmt.setInt(1, re);
			ResultSet rs = pstmt.executeQuery();
			if ( rs.next() ) {
				return new Funcionario(rs.getInt(1),
						               rs.getString(2),
						               rs.getDate(3),
						               rs.getDouble(4),
						               rs.getString(5));
			} else {
				return new Funcionario();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}

	public void alterarFuncionario(Funcionario funcionario) {
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE FUNCIONARIOS "
					+ "SET nome=?,"
					+ "dataAdmissao=?,"
					+ "salario=?,"
					+ "email=? "
					+ "WHERE re=?");
			pstmt.setString(1, funcionario.getNome());
			pstmt.setDate(2, 
			new java.sql.Date(funcionario.getDataAdmissao().getTime()));
			pstmt.setDouble(3, funcionario.getSalario());
			pstmt.setString(4, funcionario.getEmail());
			pstmt.setInt(5, funcionario.getRe());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}	
	}
}
