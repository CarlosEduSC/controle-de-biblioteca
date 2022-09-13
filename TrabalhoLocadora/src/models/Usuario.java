package models;

public class Usuario {
	private int idUsuario;
	private String nomeUsuario;
	private String email;
	private String senha;
	private TipoUsuario tipo;
	
	public int getId() {
		return idUsuario;
	}
	
	public void setId(int id) {
		this.idUsuario = id;
	}
	
	public String getNome() {
		return nomeUsuario;
	}
	
	public void setNome(String nome) {
		this.nomeUsuario = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	};
	
	
}
