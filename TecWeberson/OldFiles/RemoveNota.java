package br.insper.tecweb.p2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.tecweb.p2.model.DAONota;

@WebServlet("/remove_nt")
public class RemoveNota extends HttpServlet {
		 @Override
		protected void doGet(HttpServletRequest request,
								HttpServletResponse response)
				throws ServletException, IOException {
			 		PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<form method='post'>");
				out.println("Remover ID: <input type='number' name='id'><br>");
				out.println("<input type='submit' value='Submit'>");
				out.println("</form>");
				out.println("<body><html>");
		 }
		 @Override
		 protected void doPost(HttpServletRequest request,
				 				HttpServletResponse response)
				throws ServletException, IOException {
			 	DAONota dao = new DAONota();
			 	
			 	dao.remove(Integer.valueOf(request.getParameter("id")));
			 	Integer id_login=Integer.valueOf(request.getParameter("idlog"));
				request.setAttribute("idlog", id_login);
				request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
		dao.close();
		 }
}