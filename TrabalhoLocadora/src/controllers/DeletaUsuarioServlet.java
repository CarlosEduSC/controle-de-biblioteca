package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleta-usuario")
public class DeletaUsuarioServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Integer id = Integer.parseInt(req.getParameter("idUsuario"));
		
		try {
			DaoUsuario daoUsuario = new DaoUsuario();
			
			daoUsuario.deleteUsuario(id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("ListaUsuarios.jsp");
			dispatcher.forward(req, resp);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}