<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>operacoes</title>
</head>
<body>
<%@ page import="java.util.*,br.insper.tecweb.p2.model.*" %>
<h1>Operacoes</h1>
<%
	DAO dao = new DAO();
	List<Usuarios> pessoas = dao.getLista();
	//System.out.println(request.getParameter("idlog"));
%>
<h2>Atualizar</h2>
	<form action="EditarUsuario" method="post">
		Nome:<br>
  		<input type="text" name="nome"><br>
  		Login: <br>
  		<input type="text" name="Login"><br>
		Senha:<br>
  		<input type="text" name="senha"><br>
  		Email:<br>
  		<input type="text" name="email"><br>
  		<input type="hidden" name="id" value=<%=request.getParameter("idlog")%>><br>
  		<input type="submit" value="Atualizar">
	</form>
<h2>Remover usuario</h2>
	<form action="RemoverUsuario" method="post">
  		<input type="hidden" name="id" value=<%=request.getParameter("idlog")%>><br>
  		<input type="submit" value="Deletar">
	</form>

</body>
</html>	
