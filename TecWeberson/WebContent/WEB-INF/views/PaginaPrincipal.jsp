<link rel="stylesheet" href="PaginaInicial.css">

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