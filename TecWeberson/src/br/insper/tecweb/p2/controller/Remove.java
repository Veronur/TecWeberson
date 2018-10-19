package br.insper.tecweb.p2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.tecweb.p2.model.DAO;

@WebServlet("/remove")
public class Remove extends HttpServlet {
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
			 	DAO dao = new DAO();
			 	System.out.println(request.getParameter("id"));
			 	dao.remove(Integer.valueOf(request.getParameter("id")));
			 	
			 	request.getRequestDispatcher("Login.jsp").forward(request, response);
			 	
		dao.close();
		 }
}