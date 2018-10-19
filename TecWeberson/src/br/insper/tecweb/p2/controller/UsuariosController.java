package br.insper.tecweb.p2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import br.insper.tecweb.p2.model.DAO;
import br.insper.tecweb.p2.model.Usuarios;


@Controller
public class UsuariosController {
	@RequestMapping("/")
	 public String execute() {
	 System.out.println("Running");
	 return "login";
	 }
	
	@RequestMapping("login")
	public String Login(HttpServletRequest request,
			 				HttpServletResponse response)
			throws ServletException, IOException {
		 	DAO dao = new DAO();
		 	
		 	
		 	Usuarios pessoa = new Usuarios();
		 	pessoa.setLogin(request.getParameter("Login"));
			pessoa.setSenha(request.getParameter("senha"));
		 	Integer id_login=dao.login(pessoa);
		 	Calendar lastlogin=Calendar.getInstance();
		 	
		 	if (id_login!=null) {
		 		//System.out.println(("certo"));
		 		request.setAttribute("idlog", id_login);
		 		request.setAttribute("timelog",lastlogin);
		 		return "PaginaPrincipal";
		 		//response.sendRedirect("teste.jsp"); 
		 	}
		 	else {

				return "BadLogin";
		 	}
		 		
		 	//System.out.println(logtime.getTime());
		 	//System.out.println(id_login);
	//dao.close();
	
	
	
	
	}
}	

