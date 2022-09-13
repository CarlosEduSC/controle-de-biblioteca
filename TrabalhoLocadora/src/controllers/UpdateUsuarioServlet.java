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
import models.TipoUsuario;
import models.Usuario;

@WebServlet("/update-usuario")
public class UpdateUsuarioServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome-usuario");
		String email = req.getParameter("email-usuario");
		String senha = req.getParameter("senha-usuario");
		String tipo = req.getParameter("tipo-usuario");
		
		try {
			DaoUsuario daoUsuario = new DaoUsuario();
			Usuario usuario = new Usuario();

			TipoUsuario tu = TipoUsuario.valueOf(tipo);
			
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setTipo(tu);
			
			daoUsuario.updateUsuario(usuario);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("ListaUsuarios.jsp");
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
