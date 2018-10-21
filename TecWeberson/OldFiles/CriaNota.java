package br.insper.tecweb.p2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.tecweb.p2.model.DAONota;
import br.insper.tecweb.p2.model.Notas;

@WebServlet("/cria_nhta")
public class CriaNota extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
							HttpServletResponse response)
								throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("aberta: <input type='text' name='aberta'><br>");
		out.println("usuario_abriu: <input type='text' name='usuario_abriu'><br>");
		out.println("titulo: <input type='text' name='titulo'><br>");
		out.println("texto: <input type='text' name='texto'<br>");
		out.println("cor: <input type='text' name='cor'><br>");
		out.println("prazo_final: <input type='text' name='prazo_final'><br>");
		out.println("data_criacao: <input type='text' name='data_criacao'<br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	@Override
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
		DAONota daoNota = new DAONota();
	Notas nota = new Notas();
	nota.setAberta(Integer.valueOf(request.getParameter("aberta")));
	nota.setUsuario_abriu(Integer.valueOf(request.getParameter("usuario_abriu")));
	nota.setTitulo(request.getParameter("titulo"));
	nota.setTexto(request.getParameter("texto"));
	nota.setCor(request.getParameter("cor"));

	
	String prazo_final_nota = request.getParameter("prazo_final_nota");
	Date data = null;
	try {
		data = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(prazo_final_nota);
	} catch (ParseException e) {

		e.printStackTrace();
	}
	Calendar dataPrazo = Calendar.getInstance();
	dataPrazo.setTime(data);
 	nota.setPrazo_final(dataPrazo);

 	
 
	Calendar dataCria = Calendar.getInstance();

 	nota.setData_criacao(dataCria);
	
	
	daoNota.adiciona(nota);
	Integer id_login=Integer.valueOf(request.getParameter("usuario_abriu"));
	request.setAttribute("idlog", id_login);

	request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
		daoNota.close();
		
 }
}