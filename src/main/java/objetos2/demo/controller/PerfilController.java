package objetos2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import objetos2.demo.models.PerfilModel;
import objetos2.demo.models.UsuarioModel;
import objetos2.demo.services.PerfilService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	@Qualifier("perfilService")
	private PerfilService perfilService;

	

	//spring.jpa.hibernate.ddl-auto=update
/*
	@PostMapping("/seve")
	public String seve(@Validated Perfil u, Model model) {
		try {
			PerfilService.addJugador(u);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "formPerfil";
		}
		return "redirect:/";
	}
	*/
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("perfil", new PerfilModel());
		model.addAttribute("segunda", false);
		return "formPerfil";
	}
	
	@PostMapping("/seve")
	public String create(@ModelAttribute("perfil") PerfilModel perfilModel,Model model) {
		try {
			perfilService.insertOrUpdate(perfilModel);
			
		} catch (Exception e) {
			return "redirect:/perfil/new";
		}
		model.addAttribute("confirmacion", "Operacion sobre el perfil exitosa");
		model.addAttribute("segunda", true);
		return "formPerfil";
	}
	@GetMapping("/home/{idPerfil}")
	public String homePerfil(@ModelAttribute("idPerfil") int idPerfil,Model model) {
		model.addAttribute("perfil", perfilService.findById(idPerfil));
		return "homePerfil";
	}
	
	@GetMapping("/list")
	public ModelAndView listAllJugador() {
		ModelAndView mav = new ModelAndView("listPerfil");
		mav.addObject("perfiles", perfilService.getAll());
		return mav;
	}

	@GetMapping("/editar/{idPerfil}")
	public String editar(@ModelAttribute("idPerfil") int idPerfil, Model model) {
		PerfilModel perfil= perfilService.findById(idPerfil);
		model.addAttribute("perfil",perfil);
		return "formPerfil";
	}
	
	@GetMapping("/eliminar/{idPerfil}")
	public String delete(@ModelAttribute("idPerfil") int idPerfil, Model model) {
		perfilService.remove(idPerfil);
		return "redirect:/perfil/list";
	}
}
