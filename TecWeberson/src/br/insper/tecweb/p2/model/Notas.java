package br.insper.tecweb.p2.model;

import java.util.Calendar;

public class Notas {
	private Integer id;
	private Integer aberta;
	private Integer usuario_abriu;
	private String titulo;
	private String texto;
	private String cor;
	private Calendar prazo_final_nota;
	private Calendar data_criacao;
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	
	public Integer getAberta() {return aberta;}
	public void setAberta(Integer aberta) {this.aberta = aberta;}
	
	public Integer getUsuario_abriu() {return usuario_abriu;}
	public void setUsuario_abriu(Integer usuario_abriu) {this.usuario_abriu = usuario_abriu;}
	
	public String getTitulo() {return titulo;}
	public void setTitulo(String titulo) {this.titulo = titulo;}
	
	public String getTexto() {return texto;}
	public void setTexto(String texto) {this.texto = texto;}
	
	public String getCor() {return cor;}
	public void setCor(String cor) {this.cor = cor;}
	
	public Calendar getPrazo_final() {return prazo_final_nota;}
	public void setPrazo_final(Calendar prazo_final_nota) {this.prazo_final_nota = prazo_final_nota;}
	
	public Calendar getData_criacao() {return data_criacao;}
	public void setData_criacao(Calendar data_criacao) {this.data_criacao = data_criacao;}

}
