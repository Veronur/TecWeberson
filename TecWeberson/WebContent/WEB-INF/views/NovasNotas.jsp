<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NovasNotas</title>
</head>
<body>
<%@ page import="java.util.*,br.insper.tecweb.p2.controller.*" %>
<button onclick="window.location.href='Operacoes.jsp'">Opções de Usuário</button>

<button onclick="window.location.href='teste.jsp'">Ver Notas</button>
<h1>Qual sua nova nota?</h1>

<h2>Adicionar Nota</h2>
	<form action="cria_nota" method="post">
  		Aberta:<br>
  		<input type="number" name="aberta"><br>
  		Quem Abriu:<br>
  		<input type="number" name="usuario_abriu"><br>
		Titulo:<br>
  		<input type="text" name="titulo"><br>
  		Texto:<br>
  		<input type="text" name="texto"><br>
  		Cor:<br>
  		<input type="text" name="cor"><br>
		Prazo:<br>
  		<input type="date" name="prazo_final_nota"><br>
  		<input type="submit" value="Submit">
	</form>	
<h2>Remover Nota</h2>
	<form action="remove_nota" method="post">
  		Id: <input type="number" name="id"><br>
  		<input type="submit" value="Remover">
	</form>
<h2>Atualizar</h2>
	<form action="atualiza_nota" method="post">
		Aberta:<br>
  		<input type="number" name="aberta"><br>
  		Titulo:<br>
  		<input type="text" name="titulo"><br>
  		Texto:<br>
  		<input type="text" name="texto"><br>
  		Cor:<br>
  		<input type="text" name="cor"><br>
		Prazo:<br>
  		<input type="date" name="prazo_final_nota"><br>
  		Id: <input type="number" name="id"><br>
  		
  		<input type="submit" value="Atualiza">
	</form>





</body>
</html>