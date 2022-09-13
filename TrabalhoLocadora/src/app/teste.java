package app;

import java.time.LocalDate;
import java.util.List;

import controllers.DaoLivro;
import controllers.DaoUsuario;
import models.Livro;
import models.StatusLivro;
import models.TipoUsuario;
import models.Usuario;

public class teste {
	public static void main(String[] args) {
		Usuario u = new Usuario();
	
		u.setEmail("carloseduardodas.c@gmail.com");
		u.setNome("Carlos Eduardo da Silva Campos");
		u.setSenha("mambamentality");
		u.setTipo(TipoUsuario.Aluno);
		
		System.out.println(u.getEmail());
		System.out.println(u.getId());
		System.out.println(u.getNome());
		System.out.println(u.getSenha());
		System.out.println(u.getTipo().ordinal());
		
		
		DaoUsuario daoUsuario = new DaoUsuario();
		
//		u.setNome("Carlos");
		
//		daoUsuario.insertUsuario(u);
//		
//		daoUsuario.updateUsuario(u);
//		
//		System.out.println(u.getNome());
		
//		daoUsuario.deleteUsuario(3);
		
//		List<Usuario> usuarios = daoUsuario.findAllUsuarios();
//		
//		for (Usuario us : usuarios) {
//			System.out.println(us.getEmail());
//			System.out.println(us.getId());
//			System.out.println(us.getNome());
//			System.out.println(us.getSenha());
//			System.out.println(us.getTipo());
//		}
		
//		Usuario u = daoUsuario.findById(2);
//		
//		System.out.println(u.getEmail());
//		System.out.println(u.getId());
//		System.out.println(u.getNome());
//		System.out.println(u.getSenha());
//		System.out.println(u.getTipo());
//		
//		Livro l = new Livro();
////		
//		LocalDate data = LocalDate.of(1988, 5, 5);
//		
//		l.setStatus(StatusLivro.Disponível);
////		l.setNomeLivro("Senhor dos Aneis");
//		l.setDataCriacao(data);
//		l.setAutor("J.R.R. Martin");
////		
////		System.out.println(l.getAutor());
////		System.out.println(l.getDataCriacao());
////		System.out.println(l.getIdLivro());
////		System.out.println(l.getNomeLivro());
////		System.out.println(l.getStatus());
////		
//		DaoLivro dao = new DaoLivro();
////		
////		
//		l.setNomeLivro("Hobbit");
////		
//		
//		dao.insertLivro(l);
//		
////		dao.updateLivro(l);
////		
////		System.out.println(l.getNomeLivro());
////		
////		dao.deletProduct(3);
//		
//		List<Livro> livros = dao.findAllLivros();
//		
//		
//		for (Livro ls : livros) {
//			System.out.println(ls.getAutor());
//			System.out.println(ls.getDataCriacao());
//			System.out.println(ls.getIdLivro());
//			System.out.println(ls.getNomeLivro());
//			System.out.println(ls.getStatus());
//		}
//		
////		l = dao.findById(2);
////		
////		System.out.println(l.getAutor());
////		System.out.println(l.getDataCriacao());
////		System.out.println(l.getIdLivro());
////		System.out.println(l.getNomeLivro());
////		System.out.println(l.getStatus());
	}
}
