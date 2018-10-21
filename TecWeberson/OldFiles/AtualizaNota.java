package br.insper.tecweb.p2.controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Date;
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

@WebServlet("/atualiza_nota")
public class AtualizaNota extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<form method='post'>");
				out.println("ID: <input type='number' name='id'><br>");
				out.println("Nome: <input type='text' name='aberta'><br>");
				out.println("Login: <input type='text' name='titulo'><br>");
				out.println("Email: <input type='text' name='texto'><br>");
				out.println("Senha: <input type='text' name='prazo_final_nota' step='0.01'><br>");
				out.println("<input type='submit' value='Submit'>");
				out.println("</form>");
				out.println("<body><html>");
			}
	@Override
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
					DAONota dao = new DAONota();
					Notas nota = new Notas();
					nota.setId(Integer.valueOf(request.getParameter("id")));
					nota.setAberta(Integer.valueOf(request.getParameter("aberta")));
					nota.setTitulo(request.getParameter("titulo"));	
					nota.setTexto(request.getParameter("texto"));	
					nota.setCor(request.getParameter("cor"));
					
					String prazo_final_nota = request.getParameter("prazo_final_nota");
					Date data = null;
					try {
						data = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(prazo_final_nota);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Calendar dataPrazo = Calendar.getInstance();
					dataPrazo.setTime(data);
				 	nota.setPrazo_final(dataPrazo);
					
					dao.altera(nota);
					
					//PrintWriter out = response.getWriter();
					String idlogin= request.getParameter("idlog");
					System.out.println(idlogin);
					request.setAttribute("idlog", idlogin);
					request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
					dao.close();
					
	}
}