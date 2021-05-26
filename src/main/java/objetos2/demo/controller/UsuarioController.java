package objetos2.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import objetos2.demo.helpers.ViewRouteHelper;
import objetos2.demo.models.UsuarioModel;
import objetos2.demo.services.UsuarioService;

@Controller
//@PreAuthorize("hasRole('administrador')")
@RequestMapping("/usuario")
public class UsuarioController {


	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	
	@GetMapping("/login")
	public String login(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.LOGIN;
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.LOGOUT;
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/usuario/index";
	}

	@GetMapping("/new")
	public String create(Model model) {
		model.addAttribute("usuario", new UsuarioModel());
		return ViewRouteHelper.NEWUSUARIO;
	}
	
	@PostMapping("/seve")
	public String create(@ModelAttribute("usuario") UsuarioModel usuarioModel,Model model) {
		try {
			usuarioService.insertOrUpdate(usuarioModel);
			
		} catch (Exception e) {
			return "redirect:/usuario/new";
		}
		model.addAttribute("confirmacion", "Operacion sobre el Usuario exitosa");
		return ViewRouteHelper.NEWUSUARIO;
	}
	
	@GetMapping("/home/{idUsuario}")
	public String homeUsuario(@ModelAttribute("idUsuario") int idUsuario,Model model) {
		model.addAttribute("usuario", usuarioService.findById(idUsuario));
		return ViewRouteHelper.HOMEU;
	}
	
	@GetMapping("/index")
	public String indexUsuario(/*@ModelAttribute("idUsuario") int idUsuario,*/Model model) {
		//HashMap<String, String>	has= SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass();
		String admin= SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		String[] name=admin.substring(61, 80).split(",");
		UsuarioModel usuario = usuarioService.findByNombreUsuario(name[0]);
		//User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//usuario.get
		model.addAttribute("usuario", usuario);
		return ViewRouteHelper.HOMEU;
	}
	
	@GetMapping("/list")
	public ModelAndView listAllJugador() {
		ModelAndView mav = new ModelAndView(ViewRouteHelper.LISTUSUARIO);
		mav.addObject("usuarios", usuarioService.getAll());
		//mav.addObject("posicion", posicionService);
		return mav;
	}
	

	@GetMapping("/editar/{idUsuario}")
	public String editar(@ModelAttribute("idUsuario") int idUsuario, Model model) {
		UsuarioModel usuario= usuarioService.findById(idUsuario);
		model.addAttribute("usuario", usuario);
		return ViewRouteHelper.NEWUSUARIO;
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
