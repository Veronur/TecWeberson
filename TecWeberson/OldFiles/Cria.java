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

import br.insper.tecweb.p2.model.DAO;
import br.insper.tecweb.p2.model.Usuarios;

@WebServlet("/CrIa")
public class Cria extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
							HttpServletResponse response)
								throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("Nome: <input type='text' name='nome'><br>");
		out.println("Login: <input type='text' name='Login'><br>");
		out.println("Email: <input type='text' name='email'><br>");
		out.println("Senha: <input type='text' name='senha'<br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	@Override
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
		DAO dao = new DAO();
	Usuarios pessoa = new Usuarios();
	pessoa.setNome(request.getParameter("nome"));
	pessoa.setLogin(request.getParameter("Login"));
	pessoa.setSenha(request.getParameter("senha"));
	pessoa.setEmail(request.getParameter("email"));
	
	
	dao.adiciona(pessoa);
	response.sendRedirect("Login.jsp"); 
 }
}