package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controllers.ConnectionFactory;
import models.Livro;
import models.StatusLivro;
import models.Livro;

public class DaoLivro {
	private Connection con = ConnectionFactory.getConnection();;
	
	public Livro insertLivro(Livro livro) {
		PreparedStatement stm = null;
		int id = 0;
		
		try {
			String sql = "insert into tbLivro (nome_livro,autor,data_criacao,id_status_livro) values (?, ?, ?, ?);";
			stm = con.prepareStatement(sql, stm.RETURN_GENERATED_KEYS);
			
			stm.setString(1, livro.getNomeLivro());
			stm.setString(2, livro.getAutor());
			stm.setString(3, livro.getDataCriacao());
			stm.setInt(4, livro.getStatus().ordinal());
			
			int rowsAffected = stm.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet ids = stm.getGeneratedKeys();
				
				while (ids.next()) {
					livro.setIdLivro(ids.getInt(1));
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return livro;
	}
	
	public Livro updateLivro(Livro livro) {
		PreparedStatement stm = null;

		try {
			String sql = "update tbLivro set nome_livro= ?,autor= ?,data_criacao = ?,id_status_livro = ? where id_livro = ?";
			stm = con.prepareStatement(sql);
			
			stm.setString(1, livro.getNomeLivro());
			stm.setString(2, livro.getAutor());
			stm.setString(3, livro.getDataCriacao());
			stm.setInt(4, livro.getStatus().ordinal());
			stm.setInt(5, livro.getIdLivro());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return livro;
	}
	
	public Integer deleteLivro(int id) {
		PreparedStatement stm = null;
		
		try {
			String sql = "delete from tbLivro where id_livro = ?;";
			stm = con.prepareStatement(sql);
			
			stm.setInt(1, id);
			
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Rows Affacted: "+ rowsAffected);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Livro> findAllLivros() {
		
		List<Livro> livros = new ArrayList<Livro>();
		PreparedStatement stmt = null;
		ResultSet results = null;
		
		try {
			stmt =  con.prepareStatement("select * from tbLivro;");
			results = stmt.executeQuery();
			
			while (results.next()) {
				int id = results.getInt("id_livro");
				String nome = results.getString("nome_livro");
				String autor = results.getString("autor");
				String dataCriacao = results.getString("data_criacao");
				int status = results.getInt("id_status_livro");
				
				LocalDate data = LocalDate.parse(dataCriacao);
				
				
				
				Livro l = new Livro();
				l.setIdLivro(id);
				l.setNomeLivro(nome);
				l.setAutor(autor);
				l.setDataCriacao(data);
				l.setStatus(StatusLivro.getStatus(status));
				
				livros.add(l);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		
		}
		
		return livros;
	}
	
	public Livro findById(int id) {
		PreparedStatement stm = null;
		ResultSet result = null;
		Livro l = new Livro();
		
		try {
			stm =  con.prepareStatement("select * from tbLivro where id_livro = ?;");
			stm.setInt(1, id);
			
			result = stm.executeQuery();
				
			while (result.next()) {
				int idLivro = result.getInt("id_livro");
				String nome = result.getString("nome_livro");
				String autor = result.getString("autor");
				String dataCriacao = result.getString("data_criacao");
				int status = result.getInt("id_status_livro");
				
				LocalDate data = LocalDate.parse(dataCriacao);
				
				l.setIdLivro(idLivro);
				l.setNomeLivro(nome);
				l.setAutor(autor);
				l.setDataCriacao(data);
				l.setStatus(StatusLivro.getStatus(status));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		
		}
		
		return l;
	}
}