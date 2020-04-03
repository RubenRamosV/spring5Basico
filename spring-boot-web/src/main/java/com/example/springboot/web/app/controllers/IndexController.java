package com.example.springboot.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.web.app.models.Usuario;
import java.util.*;

@Controller
@RequestMapping(value = "/app") // ruta de primer nivel
public class IndexController {
	
	/*Se toma el valor del archivo application.properties*/
	@Value("${texto.indexcontroller.index.titulo}")
	private String titulo;
	
	/*Se toma el valor desde el archivo texto.properties. Este archivo se creo 
	 * para no saturar tanto el archivo application.properties(Solo recomendando
	 * para otro tipo de valores) en dado caso de que tengamos
	 * mas textos, se creo la clase TextoPropertiesConfig para mapear la nueva clase */
	@Value("${texto.indexcontroller.index.titulo.textos}")
	private String texto;

	/*
	 * -Para mapear a mas de una ruta, se encierra entra llaves el path -Para pasar
	 * parametros a la vista, se agrega como parametro model y se agregan los
	 * valores por medio de clave, valor. Tambien se agregan algunas anotaciones en
	 * el documento .html
	 */
	@GetMapping({ "/index", "/", "/home" }) // Ruta de segundo nivel.
	public String index(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("texto", texto);
		return "index";
	}

	@GetMapping(value = "/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Ruben");
		usuario.setApellido("Ramos");
		usuario.setEmail("Correo");
		model.addAttribute("Usuario", usuario);
		return "perfil";
	}

	@GetMapping(value = "/listado")
	public String listar(Model model) {
		/*
		 Se comenta, ya que se sustituye la lista local por el metodo
		 llenarUsuarios
		  
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Ramos","Ruben","correo"));
		usuarios.add(new Usuario("Vazquez","Erick","correo"));
		usuarios.add(new Usuario("Faba","Natalia","correo"));
		
		model.addAttribute("Usuarios", usuarios);
		*/

		return "listar";
	}
	
	
	/*
	 * Se utiliza modelAttribute cuando queremos pasar valores a la vista, 
	 * la particularidad de utilizar la anotacion ModelAttribute, es que se pasan
	 * los valores a todos las vistas que esten en el controlador.
	 * */
	@ModelAttribute("Usuarios") 
	public List<Usuario> llenarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Ramos","Ruben","correo"));
		usuarios.add(new Usuario("Vazquez","Erick","correo"));
		usuarios.add(new Usuario("Faba","Natalia","correo"));
		return usuarios;
	}

}
