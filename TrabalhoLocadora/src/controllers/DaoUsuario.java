package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.TipoUsuario;
import models.Usuario;

public class DaoUsuario {
private Connection con = ConnectionFactory.getConnection();;
	
	public Usuario insertUsuario(Usuario usuario) {
		PreparedStatement stm = null;
		int id = 0;
		
		try {
			String sql = "insert into tbUsuario (nome_usuario,email,senha,id_tipo_usuario) values (?, ?, ?, ?);";
			stm = con.prepareStatement(sql, stm.RETURN_GENERATED_KEYS);
			
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setInt(4, usuario.getTipo().ordinal());
			
			int rowsAffected = stm.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet ids = stm.getGeneratedKeys();
				
				while (ids.next()) {
					usuario.setId(ids.getInt(1));
				}
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		PreparedStatement stm = null;

		try {
			String sql = "update tbUsuario set nome_usuario= ?,email= ?,senha = ?,id_tipo_usuario = ? where id_usuario = ?";
			stm = con.prepareStatement(sql);
			
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.setInt(4, usuario.getTipo().ordinal());
			stm.setInt(5, usuario.getId());
			
			stm.executeUpdate();
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return usuario;
	}
	
	public Integer deleteUsuario(int id) {
		PreparedStatement stm = null;
		
		try {
			String sql = "delete from tbUsuario where id_usuario = ?;";
			stm = con.prepareStatement(sql);
			
			stm.setInt(1, id);
			
			int rowsAffected = stm.executeUpdate();
			
			System.out.println("Rows Affacted: "+ rowsAffected);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> findAllUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet results = null;
		
		try {
			stmt =  con.prepareStatement("select * from tbUsuario;");
			results = stmt.executeQuery();
			
			while (results.next()) {
				int id = results.getInt("id_usuario");
				String nome = results.getString("nome_usuario");
				String email = results.getString("email");
				String senha = results.getString("senha");
				int tipo = results.getInt("id_tipo_usuario");
				
				
				
				Usuario u = new Usuario();
				u.setId(id);
				u.setNome(nome);
				u.setEmail(email);
				u.setSenha(senha);
				u.setTipo(TipoUsuario.getStatus(tipo));
				
				usuarios.add(u);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		
		}
		
		return usuarios;
	}
	
	public Usuario findById(int id) {
		PreparedStatement stm = null;
		ResultSet result = null;
		Usuario u = new Usuario();
		
		try {
			stm =  con.prepareStatement("select * from tbUsuario where id_usuario = ?;");
			stm.setInt(1, id);
			
			result = stm.executeQuery();
				
			while (result.next()) {
				int idUsuario = result.getInt("id_usuario");
				String nome = result.getString("nome_usuario");
				String email = result.getString("email");
				String senha = result.getString("senha");
				int tipo = result.getInt("id_tipo_usuario");
				
				u.setId(idUsuario);
				u.setNome(nome);
				u.setEmail(email);
				u.setSenha(senha);
				u.setTipo(TipoUsuario.getStatus(tipo));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		
		}
		
		return u;
	}
}
