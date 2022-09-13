<%@page import="models.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    	<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
		
		<title>Cadastro de Livros</title>
		
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
	
		<h1>Cadastro de Livro</h1>

		<form class="row g-3 needs-validation" novalidate method="post" action="cadastro-livro">
			<div class="col-md-4">
				<label for="nomeLivro" class="form-label">Nome:</label>
				<input type="text" class="form-control" id="nomeLivro" name="nome-livro" required>
			</div>
			
			<div class="col-md-4">
				<label for="autorLivro" class="form-label">Autor:</label>
				<input type="" class="form-control" id="autorLivro" name="autor-livro" required>
			</div>

			<div class="col-md-6">
				<label for="dataCriacao" class="form-label">Data de criação:</label>
				<input type="date" class="form-control" id="dataCriacao" name="data-criacao" required>
			</div>

			<div class="col-md-3">
				<label for="statusLivro" class="form-label">Status do livro:</label>
				<select class="form-select" id="statusLivro" name="status-livro" required>
					<option selected disabled value="">Selecione uma opção</option>
					<option value="Disponivel">Disponível</option>
					<option value="Emprestado">Emprestado</option>
					<option value="Indisponivel">Indisponível</option>
				</select>
			</div>
			
			<div class="col-12">
				<button class="btn btn-primary" type="submit">Cadastrar livro</button>
			</div>
		</form>
	</body>
</html>