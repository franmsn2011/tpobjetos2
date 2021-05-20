package objetos2.demo.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	
	//@GetMapping("/index")
	@GetMapping("/index")
	public String devolverformulario() {
		return "login";
	}
	@GetMapping("/")
	public String holam() {
		return "hola";
	}
	/*
	@GetMapping("/res")
	public String traerPersonas(Model model) {
		model.addAttribute("p",traerPersonas());
		return "resultado2";
	}
		
	@PostMapping("/resultado")
	public String resultado(Persona persona, Model model) {
		model.addAttribute("persona", persona);
		model.addAttribute("resultado", "resultado del formulario");
		return "resultado";
	}
	public java.util.List<Persona> traerPersonas(){
		java.util.List<Persona> p= new ArrayList<>();
		p.add(new Persona("juan", 1234, "gomez", 421111, false));
		p.add(new Persona("maria", 2345, "apellido", 422222, false));
		p.add(new Persona("franco", 2345, "gonzales", 3244544, true));
		p.add(new Persona("pedro", 44335343, "falso", 123432, true));
		return p;
	}
	*/
}