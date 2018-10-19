<style>
.botoes{
	margin-top:1em;
	display: flex;
	flex-direction: row;
}
h5{
	margin-top:3em;
	margin-bottom:0em;
}
h4{
	margin-left:1em;
	margin-top:5;
	margin-bottom:0;
	font-size:13px
}
.datas {
	margin-top:2em;
	margin-left:2em;
	margin-right:2em;
}

.botao_novo_nota{
	display: flex;
	margin-left: 5em;
	margin-bottom: 1em;
	justify-content: left;
}   
.flex-container {
  display: flex;
  flex-direction: row;
  margin-left: 5em;
  margin-right: 5em;
  width:100%;
  
}
.flex-container2 {
  display: flex;
  flex-direction: row;
  justify-content: center;
  
}

.nota {
  text-decoration:none;
  color:#000;
  background:#ffc;
  display:block;
  width:30%;
  margin-right:3em;
  padding: 1em;
  box-shadow: 5px 5px 7px rgba(33,33,33,.7);
  border-radius: 5px;
	
}
.titulo {
  display: flex;
  justify-content: center;
  
}
.titulo_pagina {
  display: flex;
  justify-content: center;
  font-family: "Comic Sans MS", cursive, sans-serif;
  font-size: 2em;
  color: #ffc	;
  text-shadow: 2px 1px black;
  
  
}
.texto {
  display: flex;
  word-break:break-all;
  
}
body{
  display: inline-block;
  font-family:arial,sans-serif;
  font-size:100%;
  background:#EBE6DD;
  width:100%;
  color:#fff;
}



</style>

 <body>
 	
<%@ page import="java.util.*,br.insper.tecweb.p2.model.*" %>

	<div class="titulo_pagina">
		<h2>Notas</h2>
	</div>
	<div class="botao_novo_nota">
		<button onclick="window.location.href='NotaNova.jsp?idlog=<%=request.getAttribute("idlog")%>'">Nota Nova</button>
		<button onclick="window.location.href='Operacoes.jsp?idlog=<%=request.getAttribute("idlog")%>'">Opções</button>
	</div>
 	<div class="flex-container">
	
<%
	DAONota daonota = new DAONota();
	

	List<Notas> notas = daonota.getListaNota(String.valueOf(request.getAttribute("idlog")));
	for (Notas nota : notas ) {
%>
	<div class="nota" style="background-color: <%=nota.getCor()%>">
	 		<div class="titulo">
	 			<h2><%=nota.getTitulo()%></h2>
	 			</div>
	 		<div class="texto"><%=nota.getTexto()%></div>
	 		<div class="flex-container2">
	 		<div class='datas'>
		 		<h5>Data da Criação:</h5>
		 		
		 			<h4><div class="prazo_final"><%=nota.getData_criacao().get(Calendar.DAY_OF_MONTH)%>/<%=nota.getData_criacao().get(Calendar.MONTH)%>/<%=nota.getData_criacao().get(Calendar.YEAR)%></div></h4>
		 		
	 		</div>
	 		<div class='datas'>
	 			<h5>Data Prazo Final:</h5>
	 			 		
	 		<h4><div class="prazo_final"><%=nota.getPrazo_final().get(Calendar.DAY_OF_MONTH)%>/<%=nota.getPrazo_final().get(Calendar.MONTH)%>/<%=nota.getPrazo_final().get(Calendar.YEAR)%></div></h4>
	 		
	 		</div>
	 		</div>
	 		<div class='botoes'>
	 			<div>
		 		<form action="remove_nota" method="post">
			  		<input type="hidden" name="id" value="<%=nota.getId()%>">
			  		<input type="hidden" name="idlog" value="<%=request.getAttribute("idlog")%>">
			  		<input type="submit" value="Delete">
				</form>
				</div>
				<div>
				<button onclick="window.location.href='EditarNota.jsp?id=<%=nota.getId()%>&idlog=<%=request.getAttribute("idlog")%>'">Editar</button>
				</div>
			</div>
	</div>
<% } %>
</div>

</body>