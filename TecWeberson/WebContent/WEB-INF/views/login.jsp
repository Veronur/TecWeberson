<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@ page import="java.util.*,br.insper.tecweb.p2.model.*" %>
<h1>Bem Vindo!</h1>
<%
	DAO dao = new DAO();
	List<Usuarios> pessoas = dao.getLista();
%>
	<form action="login" method="post">
		Login:<br>
  		<input type="text" name="Login"><br>
		Senha:<br>
  		<input type="text" name="senha"><br>
		<input type="submit" value="LOGIN">
	</form>
	<form action="NewUser" method="post">
	<input type="submit" value="Registrar"/> 
	</form>


</body>
</html>