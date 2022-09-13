<%@page import="models.Usuario"%>
<%@page import="models.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
        
		<title>Atualizar Usuario</title>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">Menu</a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
		      <ul class="navbar-nav">
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Opções Usuario
		          </a>
		          <ul class="dropdown-menu dropdown-menu-dark">
		            <li><a class="dropdown-item" href="CadastroUsuario.jsp">Cadastrar usuario</a></li>
		            <li><a class="dropdown-item" href="findUser.jsp">Atualizar dados de um usuario</a></li>
		            <li><a class="dropdown-item" href="ListaUsuarios.jsp">Lista de usuarios</a></li>
		          </ul>
		        </li>
		        <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		          Opções Livro
		        </a>
		        <ul class="dropdown-menu dropdown-menu-dark">
		         	<li><a class="dropdown-item" href="CadastroLivro.jsp">Cadastrar livro</a></li>
		          	<li><a class="dropdown-item" href="findBook.jsp">Atualizar dados de um livro</a></li>
		          	<li><a class="dropdown-item" href="ListaLivrosAdmin.jsp">Lista de livros</a></li>
		        </ul>
		      </li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<% Usuario u = (Usuario)request.getAttribute("usuario"); %>
	
		<h1>Atualizar Usuario</h1>
		
		<form class="row g-3 needs-validation" novalidate>
			<div class="col-md-4">
				<label for="nomeUsuario" class="form-label">Nome:</label>
				<input type="text" class="form-control" id="nomeUsuario" name="nome-usuario" value="<%= u.getNome() %>" required>
			</div>
			
			<div class="col-md-4">
				<label for="emailUsuario" class="form-label">Email:</label>
				<input type="email" class="form-control" id="emailUsuario" name="email-usuario" value="<%= u.getEmail() %>" required>
			</div>

			<div class="col-md-6">
				<label for="senhaUsuario" class="form-label">Senha:</label>
				<input type="password" class="form-control" id="senhaUsuario" name="senha-usuario" value="<%= u.getSenha() %>" required>
			</div>

			<div class="col-md-3">
				<label for="tipoUsuario" class="form-label">Tipo de Usuario:</label>
				<select class="form-select" id="tipoUsuario" name="tipo-usuario" required>
					<option selected disabled value="">Selecione uma opção</option>
					<option value="Administrador">Administrador</option>
					<option value="Aluno">Aluno</option>
				</select>
			</div>
			
			<div class="col-12">
				<button class="btn btn-primary" type="submit">Atualizar usuario</button>
			</div>
		</form>
	</body>
</html>