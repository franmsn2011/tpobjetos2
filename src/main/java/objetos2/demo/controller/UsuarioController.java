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

import objetos2.demo.models.UsuarioModel;
import objetos2.demo.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	private static final int NINGUN_EQUIPO = 15;

	private static final String USUARIO_KEY = "usuario";

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	

	//spring.jpa.hibernate.ddl-auto=update
/*
	@PostMapping("/seve")
	public String seve(@Validated Usuario u, Model model) {
		try {
			UsuarioService.addJugador(u);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage());
			return "formUsuario";
		}
		return "redirect:/";
	}
	*/
	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("usuario", new UsuarioModel());
		return "formUsuario";
	}
	
	@PostMapping("/seve")
	public String create(@ModelAttribute("usuario") UsuarioModel usuarioModel) {
		try {
			usuarioService.insertOrUpdate(usuarioModel);
			
		} catch (Exception e) {
			return "redirect:/usuario/new";
		}
		return "redirect:/";
	}
	@GetMapping("/home/{idUsuario}")
	public String homeUsuario(@ModelAttribute("idUsuario") int idUsuario,Model model) {
		model.addAttribute("usuario", usuarioService.findById(idUsuario));
		return "homeUsuario";
	}
	@GetMapping("/list")
	public ModelAndView listAllJugador() {
		ModelAndView mav = new ModelAndView("listUsuario");
		mav.addObject("usuarios", usuarioService.getAll());
		//mav.addObject("posicion", posicionService);
		return mav;
	}
	

	@GetMapping("/editar/{idUsuario}")
	public String editar(@ModelAttribute("idUsuario") int idUsuario, Model model) {
		UsuarioModel usuario= usuarioService.findById(idUsuario);
		model.addAttribute("usuario", usuario);
		return "formUsuario";
	}
	
	@GetMapping("/eliminar/{idUsuario}")
	public String delete(@ModelAttribute("idUsuario") int idUsuario, Model model) {
		usuarioService.darDeBaja(idUsuario);
		return "redirect:/usuario/list";
	}
	/*
	@GetMapping("/traerJEP")
	public String agegar2(Model model) {
		model.addAttribute(JUGADOR_KEY, new Jugador());
		return "formEP";
	}

	@PostMapping("/formEP")
	public String formEP(@Validated Jugador j) {
		return "redirect:/jugador/verJugadores/" + j.getPosicion() + "/" + j.getEquipo();
	}
*/
}
