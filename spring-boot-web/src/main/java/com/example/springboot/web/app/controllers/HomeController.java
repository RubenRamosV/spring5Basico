package com.example.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/*Este controler solo sirve para redireccionar. Existen dos maneras para mandar a otra pagina
	 con redirect y con foward. 
	 Con redirect, se recarga toda la pagina, es decir, si teniamos algun parametro en el request, estos
	 valores se pierden. 
	 
	 Con foward, se conservan los mismos parametros del request, solo se hace una recarga "por debajo" y es lo
	 ideal para moverse entre las paginas de los controladores, no se puede hacer forward a una pagina externa.
	 */
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}

}
