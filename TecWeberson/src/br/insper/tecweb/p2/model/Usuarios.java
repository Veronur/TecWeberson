package br.insper.tecweb.p2.model;


public class Usuarios {
	
	private Integer id;
	private String nome;
	private String senha;
	private String email;
	private String Login;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNome() {return this.nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getLogin() {return this.Login;}
	public void setLogin(String Login) {this.Login = Login;}
	
	public String getSenha() {return this.senha;}
	public void setSenha( String senha) {this.senha = senha;}
	
	public String getEmail() {return this.email;}
	public void setEmail(String email) {this.email = email;}
}