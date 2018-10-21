package br.insper.tecweb.p2.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import br.insper.tecweb.p2.model.DAO;
import br.insper.tecweb.p2.model.Usuarios;

import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")
public class Lista extends HttpServlet {
	protected void service(HttpServletRequest request,
							HttpServletResponse response)
			throws ServletException, IOException {
		
			DAO dao = new DAO();
			
			List<Usuarios> usuarios = dao.getLista();
			
			PrintWriter out = response.getWriter();
			out.println("<html><body><table border='1'>");
			out.println("<tr><td>ID</td><td>Nome</td>" +
					"<td>Login</td><td>Email</td><td>Senha</td></tr>");
			for (Usuarios pessoa : usuarios) {
				 out.println("<tr><td>" + pessoa.getId() + "</td>");
				 out.println("<td>" + pessoa.getNome() + "</td>");
				 out.println("<td>" + pessoa.getLogin() + "</td>");
				 out.println("<td>" + pessoa.getEmail() + "</td>");
				 out.println("<td>" + pessoa.getSenha() + "</td></tr>");
				}
			out.println("</table></body></html>");

			dao.close();

	}
}