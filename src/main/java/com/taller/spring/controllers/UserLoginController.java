package com.taller.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller.spring.entity.Client;
import com.taller.spring.repository.ClientRepository;

@Controller
@RequestMapping(path = "/client")
public class UserLoginController {
	@Autowired
	private ClientRepository clienteRepository;

	@PostMapping(value = "/buscarUsuario")
	public String guardarCliente(@ModelAttribute @Validated Client client, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			return "/";
		}

		if (clienteRepository.findByUsername(client.getUsername()) == null) {
			redirectAttrs.addFlashAttribute("mensaje", "El usuario no existe").addFlashAttribute("clase", "warning");
		} else if (clienteRepository.findByUsernameAndPassword(client.getUsername(), client.getPassword()) != null) {
			if (client.getRol() == true) {
				return "redirect:/perfil_usuario_admin";
			}else {
				return "redirect:/mostrar_clientes";
			}

		} else {
			redirectAttrs.addFlashAttribute("mensaje", "La contraseña no es válida").addFlashAttribute("clase",
					"warning");
		}
		return "redirect:/";
	}
}
