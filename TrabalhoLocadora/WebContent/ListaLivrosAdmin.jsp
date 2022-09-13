<%@page import="models.TipoUsuario"%>
<%@page import="models.Livro"%>
<%@page import="java.util.List"%>
<%@page import="controllers.DaoLivro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
		
    <title>Lista de Livros</title>

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
	
		<h1>Lista de Livros</h1>
		
		<%
			DaoLivro daoLivro = new DaoLivro();
			
			List<Livro> livros = daoLivro.findAllLivros();
		%>
		
		<table class="table">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Nome</th>
          <th scope="col">Autor</th>
          <th scope="col">Data de Criação</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <% 
      	for (Livro l : livros) {
      	
      	request.setAttribute("idLivro", l.getIdLivro());
      %>
      <tbody>
        <tr>
          <th></th>
          <td scope="col"><%= l.getIdLivro() %></td>
          <td scope="col"><%= l.getNomeLivro() %></td>
          <td scope="col"><%= l.getAutor() %></td>
          <td scope="col"><%= l.getDataCriacao() %></td>
          <td scope="col"><%= l.getStatus() %></td>
          <td>
          	<a href="deleta-livro?idLivro=<%= l.getIdLivro()%>" value="idLivro">Deletar</a>
		  </td>
        </tr>
      </tbody>
      <%} %>
    </table>
	</body>
</html>