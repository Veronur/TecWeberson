<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BadLogin</title>
</head>
<body>
<h1>Este Facebook ainda nao foi Registrado, defina uma senha.</h1>
<%@ page import="java.util.*,br.insper.tecweb.p2.controller.*" %>
	<form action="cria" method="post">
  		Nome: <%=request.getParameter("Login")%><br>
  		<input type="hidden" name="nome" value="<%=request.getParameter("Login")%>">
  		Login: <%=request.getParameter("Login")%><br>
  		<input type="hidden" name="Login" value="<%=request.getParameter("Login")%>">
  		Email: <%=request.getParameter("Email")%><br>
  		<input type="hidden" name="email" value="<%=request.getParameter("Email")%>">
  		<input type="hidden" name="senha" value="1233^&75">
  		
  		<input type="submit" value="Cria">
	</form>	
</body>
</html>