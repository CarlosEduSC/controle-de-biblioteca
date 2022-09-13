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
      <% for (Livro l : livros) {%>
      <tbody>
        <tr>
          <th></th>
          <td scope="col"><%= l.getIdLivro() %></td>
          <td scope="col"><%= l.getNomeLivro() %></td>
          <td scope="col"><%= l.getAutor() %></td>
          <td scope="col"><%= l.getDataCriacao() %></td>
          <td scope="col"><%= l.getStatus() %></td>
        </tr>
      </tbody>
      <%} %>
    </table>
	</body>
</html>