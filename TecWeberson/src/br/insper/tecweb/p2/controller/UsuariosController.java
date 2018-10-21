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
		 	//pessoa.setSenha("1");
			pessoa.setSenha(request.getParameter("senha"));
		 	Integer id_login=dao.login(pessoa);
		 	Calendar lastlogin=Calendar.getInstance();
		 	System.out.println(id_login);
		 	
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
	
	@RequestMapping("NewUser")
	public String NewUser() {
		 System.out.println("CLICK");
		 return "NewUser";
		 }
	@RequestMapping("cria")
	public String Cria(HttpServletRequest request,
			 				HttpServletResponse response)
			throws ServletException, IOException {
		 	DAO dao = new DAO();
		Usuarios pessoa = new Usuarios();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setLogin(request.getParameter("Login"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa.setEmail(request.getParameter("email"));


		dao.adiciona(pessoa);
		return "login";
		 }
	@RequestMapping("Opcoes")
	public String OpcoesPage() {
		return "Operacoes";
	}
	@RequestMapping("RemoverUsuario")
	public String RemoverUsuario(HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException {
		DAO dao = new DAO();
		System.out.println(request.getParameter("id"));
		dao.remove(Integer.valueOf(request.getParameter("id")));

	return "login";
	}
	
	@RequestMapping("EditarUsuario")
	public String EditarUsuario(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
	DAO dao = new DAO();
	Usuarios pessoa = new Usuarios();
	pessoa.setId(Integer.valueOf(request.getParameter("id")));
	pessoa.setNome(request.getParameter("nome"));	
	pessoa.setLogin(request.getParameter("Login"));	
	pessoa.setSenha(request.getParameter("senha"));	
	pessoa.setEmail(request.getParameter("email"));
	
	
	dao.altera(pessoa);
	request.setAttribute("idlog", request.getParameter("id"));
	
	
	return "PaginaPrincipal";
}
	@RequestMapping("FbLogin")
	public String Look() {
		return "FbLogin";
	}
	@RequestMapping("loginFacebook")
	public String loginFacebook(HttpServletRequest request,
			 				HttpServletResponse response)
			throws ServletException, IOException {
		 	DAO dao = new DAO();
		 	
		 	
		 	Usuarios pessoa = new Usuarios();
		 	pessoa.setLogin(request.getParameter("Login"));
		 	pessoa.setNome(request.getParameter("Login"));
		 	pessoa.setEmail(request.getParameter("email"));
		 	pessoa.setSenha("1233^&75");
			//pessoa.setSenha(request.getParameter("senha"));
		 	Integer id_login=dao.login(pessoa);
		 	Calendar lastlogin=Calendar.getInstance();
		 	System.out.println(id_login);
		 	
		 	if (id_login!=null) {
		 		//System.out.println(("certo"));
		 		request.setAttribute("idlog", id_login);
		 		request.setAttribute("timelog",lastlogin);
		 		return "PaginaPrincipal";
		 		//response.sendRedirect("teste.jsp"); 
		 	}
		 	else {

				return "BadLoginFacebook";
		 	}
	
}
}