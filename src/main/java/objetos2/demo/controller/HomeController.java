package objetos2.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

/*	@GetMapping({ "/traer", "" })
	public ModelAndView listAllPosicion() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}*/
	
	@GetMapping("/")
	public String mostrarHome() {
		return "home";
	}
	
}
