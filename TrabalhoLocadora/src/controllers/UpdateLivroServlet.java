package controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livro;
import models.StatusLivro;

@WebServlet("/update-livro")
public class UpdateLivroServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id-livro");
		String nome = req.getParameter("nome-livro");
		String autor = req.getParameter("autor-livro");
		String dataCriacao = req.getParameter("data-cricao");
		String status = req.getParameter("status-livro");
		
		try {
			DaoLivro daoLivro = new DaoLivro();
			Livro livro = new Livro();
			
			List<Livro> livros = daoLivro.findAllLivros();
			
			for (Livro l : livros) {
				if (l.getIdLivro() == Integer.parseInt(id)) {
					req.setAttribute("id", id);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateLivro.jsp");
					dispatcher.forward(req, resp);
				}
			}
			
			
			
			LocalDate data = LocalDate.parse(dataCriacao);
			StatusLivro st = StatusLivro.valueOf(status);
			
			livro.setNomeLivro(nome);
			livro.setAutor(autor);
			livro.setDataCriacao(data);
			livro.setStatus(st);
			
			daoLivro.updateLivro(livro);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("ListaLivrosAdmin.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
