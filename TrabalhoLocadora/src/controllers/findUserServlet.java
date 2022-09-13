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
import models.Usuario;

@WebServlet("/find-user")
public class findUserServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id-usuario");
		
		try {
			DaoUsuario daoUsuario = new DaoUsuario();
			
			List<Usuario> usuarios = daoUsuario.findAllUsuarios();
			int cont = 0;
			String erro = "Usuario não encontrado!";
			
			for (Usuario u : usuarios) {
				if (u.getId() == Integer.parseInt(id)) {
					req.setAttribute("usuario", u);
					
					RequestDispatcher dispatcher = req.getRequestDispatcher("UpdateUsuario.jsp");
					dispatcher.forward(req, resp);
					
					cont = 1;
				}
			}
			
			if (cont == 0) {
				req.setAttribute("erro-findUser", erro);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("findUser.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}