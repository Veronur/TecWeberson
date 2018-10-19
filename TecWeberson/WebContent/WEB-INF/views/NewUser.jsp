<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewUser</title>
</head>
<body>
<%@ page import="java.util.*,br.insper.tecweb.p2.controller.*" %>
<h2>Adicionar Usuário</h2>
	<form action="cria" method="post">
  		Nome:<br>
  		<input type="text" name="nome"><br>
  		Login:<br>
  		<input type="text" name="Login"><br>
		Senha:<br>
  		<input type="text" name="senha"><br>
  		Email:<br>
  		<input type="text" name="email"><br>
  		
  		<input type="submit" value="Cria">
	</form>	
</body>

</html>