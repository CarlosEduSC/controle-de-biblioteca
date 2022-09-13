package models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Livro {
	private int idLivro;
	private String nomeLivro;
	private LocalDate dataCriacao;
	private String autor;
	private StatusLivro status;
	
	public int getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	
	public String getNomeLivro() {
		return nomeLivro;
	}
	
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public String getDataCriacao() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		
		String data = dataCriacao.format(formatador);
		
		return data;
	}
	
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public StatusLivro getStatus() {
		return status;
	}
	
	public void setStatus(StatusLivro status) {
		this.status = status;
	}
}
