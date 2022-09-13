<%@page import="models.TipoUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
        
        <title>Atualizar Livro</title>

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
    
        <h1>Atualizar Livro</h1>
        
        	<% String erro = (String) request.getAttribute("erro-findBook"); %>
		
			<% if(erro != null){ %>
			<p><% out.println(erro); %></p>
			<% } %>

	        <form class="row g-3 needs-validation" method="post" action="find-book" novalidate>
				<div class="col-md-4">
					<label for="idLivro" class="form-label">Digite o Id do livro que deseja alterar:</label>
					<input type="text" class="form-control" id="idLivro" name="id-livro" required>
				</div>
				
				<div class="col-12">
					<button class="btn btn-primary" type="submit">Buscar Livro</button>
				</div>
			</form>
    </body>
</html>