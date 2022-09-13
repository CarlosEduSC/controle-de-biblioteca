package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livro;

@WebServlet("/deleta-livro")
public class DeletaLivroServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(req.getParameter("idLivro"));
		
		try {
			DaoLivro daoLivro = new DaoLivro();
			
			daoLivro.deleteLivro(id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("ListaLivrosAdmin.jsp");
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
