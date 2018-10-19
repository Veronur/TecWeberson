package br.insper.tecweb.p2.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UsuariosController {
	@RequestMapping("/")
	 public String execute() {
	 System.out.println("Vou Chorar");
	 return "login";
	 }
	}

