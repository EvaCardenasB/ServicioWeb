package com.taller.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador principal 
 * @author Eva
 *
 */
@Controller
public class InicioController {
	@GetMapping("/")
	public String indexController() {
		return "login";
	}
	
	@GetMapping("/perfil_usuario_admin")
	public String perfilAdminController() {
		return "perfil_usuario_admin";
	}
	
	@GetMapping("/mostrar_clientes")
	public String perfilGeneralController() {
		return "mostrar_clientes";
	}
}
