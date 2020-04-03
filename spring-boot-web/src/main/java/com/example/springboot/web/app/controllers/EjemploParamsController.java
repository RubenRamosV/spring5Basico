package com.example.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/index")
	public String index() {

		return "params/index";
	}

	@GetMapping("/string")
	public String params(
			@RequestParam(name = "nombreParametro", required = false, defaultValue = "No se envio parametro") String parametro,
			Model model) {
		model.addAttribute("parametro", parametro);
		return "params/ver";
	}

	@GetMapping("/parametro")
	public String param(HttpServletRequest request, Model model) {
		model.addAttribute("parametro", request.getParameter("nombre"));
		return "params/ver";
	}
}
