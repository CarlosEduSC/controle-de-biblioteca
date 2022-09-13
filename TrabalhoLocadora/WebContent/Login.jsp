<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    	<link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    	
		<title>Login Biblioteca</title>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	
	<body>
	
		<% String erro = (String) request.getAttribute("erro"); %>
		
		<% if(erro != null){ %>
		<p><% out.println(erro); %></p>
		<% } %>
	
		<h1>Login</h1>
		
		<form action="login" method="Post" class="row g-3 needs-validation" novalidate>
			<div class="col-md-4">
				<label for="email" class="form-label">Email:</label>
				<input type="email" class="form-control" id="email" name="login-email" required>
			</div>

			<div class="col-md-6">
				<label for="senha" class="form-label">Senha:</label>
				<input type="password" class="form-control" id="senha" name="login-senha" required>
			</div>
			
			<div class="col-12">
				<button class="btn btn-primary" type="submit">Entrar</button>
			</div>
		</form>
	</body>
</html>