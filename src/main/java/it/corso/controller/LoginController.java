package it.corso.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Film;
import it.corso.service.AttoreService;
import it.corso.service.FilmService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AttoreService attoreService;
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public String getPage(
			@RequestParam (name="err", required=false) String logError,
			HttpSession session,
			Model model
			) 
	{
		
		if (session.getAttribute("attore")!=null) {
			return"redirect:/areariservata";
		}
		model.addAttribute("logError", logError!=null);
		
		//NAV BAR
		List<Film> films = filmService.getFilms();
		Map<String, List<Film>> filmPerGenere2 = filmService.getFilmByGenere(films);
		model.addAttribute("filmPerGenere2", filmPerGenere2);
		model.addAttribute("attorelog", session.getAttribute("attore") != null);
		//FINE NAVBAR
		return "login";
	}
	
	@PostMapping
	public String gestioneLogin(@RequestParam ("email") String email,
							  @RequestParam("password") String password,
							  HttpSession session,
							  Model model) {
		
		if (!attoreService.controlloLogin(email,password,session)) {
			return "redirect:/login?err";
		}
		return "redirect:/areariservata";
	}
	
	
}