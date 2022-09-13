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
import models.TipoUsuario;
import models.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String email = req.getParameter("login-email");
		String senha = req.getParameter("login-senha");
		String erro = null;
		
				
		try {		
			Usuario usuario = null;
			DaoUsuario daoUsuario = new DaoUsuario();
			List<Usuario> usuarios = daoUsuario.findAllUsuarios();
			
			for (Usuario u : usuarios) {
				if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
					usuario = u;
				}
			}
			
			String tipo = usuario.getTipo().name();
			
			if (usuario == null) {
				erro = "Email e senha incorretos!";
				req.setAttribute("erro", erro);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.jsp");
				dispatcher.forward(req, resp);
			
			} else {
				if (usuario.getTipo().equals(TipoUsuario.Administrador)) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("ListaLivrosAdmin.jsp");
					dispatcher.forward(req, resp);
				
				} else if (usuario.getTipo().equals(TipoUsuario.Aluno)) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("ListaLivrosUser.jsp");
					dispatcher.forward(req, resp);
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
						
		}
	}

}
