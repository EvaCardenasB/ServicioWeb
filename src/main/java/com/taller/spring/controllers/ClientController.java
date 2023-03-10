package com.taller.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.taller.spring.entity.Client;
import com.taller.spring.repository.ClientRepository;

/**
 * 
 * Controlador para llevar a cabo las acciones del cliente
 * @author Eva
 *
 */
@Controller
@RequestMapping(path = "/client")
public class ClientController {
	@Autowired
	private ClientRepository clienteRepository;

	@GetMapping(value = "/agregar")
	public String agregarCliente(Model model) {
		model.addAttribute("client", new Client());
		return "/add_client";
	}

	// Agregar un cliente a la DB
	@PostMapping(value = "/agregar")
	public String guardarCliente(@ModelAttribute @Validated Client client, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			return "client/agregar";
		}
		if (clienteRepository.findByUsername(client.getUsername()) != null) {
			redirectAttrs.addFlashAttribute("mensaje", "Ya existe un cliente con ese dni").addFlashAttribute("clase",
					"warning");
			return "redirect:/client/agregar";
		}
		clienteRepository.save(client);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/";
	}

	
}
