package objetos2.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import objetos2.demo.entities.Usuario;
import objetos2.demo.models.Login;
import objetos2.demo.models.UsuarioModel;
import objetos2.demo.services.UsuarioService;



@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	
	//@GetMapping("/index")
	@GetMapping("/")
	public String devolverformulario(Model model) {
		model.addAttribute("login", new Login());
		
		return "login";
	}
	@PostMapping("/resultado")
	public String resultado(@ModelAttribute("login") Login login, Model model) {
		UsuarioModel usuarioModel = usuarioService.findByNombre(login.getNombre());
		if(usuarioModel==null) {
			model.addAttribute("exception", "Error no existe un usuario con ese nombre");
			return "login";
		}
		if(usuarioService.validoPassword(usuarioModel, login.getPassword())) {
			model.addAttribute("exception", "Contraseña incorrecta intente otra vez");
			return "login";
		} 
		
		model.addAttribute("usuario", usuarioModel);
		return "redirect:/usuario/home/"+usuarioModel.getIdUsuario();
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