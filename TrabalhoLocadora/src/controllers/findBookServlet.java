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

@WebServlet("/find-book")
public class findBookServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id-livro");
		
		try {
			DaoLivro daoLivro = new DaoLivro();
			
			List<Livro> livros = daoLivro.findAllLivros();
			int cont = 0;
			String erro = "Livro não encontrado!";
			
			for (Livro l : livros) {
				if (l.getIdLivro() == Integer.parseInt(id)) {
					req.setAttribute("livro", l);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateLivro.jsp");
					dispatcher.forward(req, resp);
					
					cont = 1;
				}
			}
			
			if (cont == 0) {
				req.setAttribute("erro-findBook", erro);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("findBook.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}