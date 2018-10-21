<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Voce Esta a um Passo de Entrar</h1>

	<form action="loginFacebook" method="post">
  		<input type="hidden" name="Login" value=<%=request.getParameter("user_name")%>>
  		<input type="hidden" name="Email" value=<%=request.getParameter("user_email")%>>
  		<button onclick="window.location.href='loginFacebook?%>'">Voce Deseja Realemnte logar com o Facebook?</button>
	</form>	
</center>
</body>
</html>