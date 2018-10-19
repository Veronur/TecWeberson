	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Atualizar Nota</h2>
	<form action="atualiza_nota" method="post">
		<input type="hidden" name="aberta" value="1">
  		Titulo:<br>
  		<input type="text" name="titulo"><br>
  		Texto:<br>
  		<input type="text" name="texto"><br>
  		Cor:<br>
  		<input type="color" name="cor"><br>
		Prazo:<br>
  		<input type="date" name="prazo_final_nota"><br>
  		<input type="hidden" name="id" value=<%=request.getParameter("id") %>><br>
  		<input type="hidden" name="idlog" value=<%=request.getParameter("idlog") %>><br>
  		<input type="submit" value="Atualiza">
	</form>
	</body>
</html>
	