package controllers;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livro;
import models.StatusLivro;

@WebServlet("/cadastro-livro")
public class CadastroLivroServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome-livro");
		String autor = req.getParameter("autor-livro");
		String dataCriacao = req.getParameter("data-criacao");
		String status = req.getParameter("status-livro");
		
		try {
			DaoLivro daoLivro = new DaoLivro();
			Livro livro = new Livro();
			
			LocalDate data = LocalDate.parse(dataCriacao);
			StatusLivro st = StatusLivro.valueOf(status);
			
			
			
			livro.setNomeLivro(nome);
			livro.setAutor(autor);
			livro.setDataCriacao(data);
			livro.setStatus(st);
			
			daoLivro.insertLivro(livro);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("ListaLivrosAdmin.jsp");
			dispatcher.forward(req, resp);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
