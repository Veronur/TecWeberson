package br.insper.tecweb.p2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import br.insper.tecweb.p2.model.DAO;
import br.insper.tecweb.p2.model.DAONota;
import br.insper.tecweb.p2.model.Notas;
import br.insper.tecweb.p2.model.Usuarios;


@Controller
public class NotasController {
	@RequestMapping("edita_nota")
	public String EditPage() {
		return "EditarNota";
	}
	
	@RequestMapping("edita")
	public String Editar(HttpServletRequest request,
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
	return "PaginaPrincipal";
	
	}

	@RequestMapping("remove_nota")
	public String Remove(HttpServletRequest request,
				HttpServletResponse response)
						throws ServletException, IOException {
		DAONota dao = new DAONota();

	dao.remove(Integer.valueOf(request.getParameter("id")));
	Integer id_login=Integer.valueOf(request.getParameter("idlog"));
	request.setAttribute("idlog", id_login);
	return "PaginaPrincipal";
	}
	
	@RequestMapping("nova_nota")
	public String CreatePage() {
		return "NotaNova";
	}
	
	@RequestMapping("CriarNota")
	public String CriaNota(HttpServletRequest request,
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
		return "PaginaPrincipal";
		}

}

