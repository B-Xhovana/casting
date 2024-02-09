package it.corso.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Attore;
import it.corso.model.Film;
import it.corso.service.AttoreService;
import it.corso.service.FilmService;
import jakarta.servlet.http.HttpSession;

//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired AttoreService attoreService;
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		List<Film> films = filmService.getFilms();
		Map<String, List<Film>> filmPerGenere = filmService.getFilmByGenere(films);
		model.addAttribute("filmPerGenere", filmPerGenere);
		
		model.addAttribute("attorelog", session.getAttribute("attore") != null);
		List<Attore> attori = attoreService.getAttoriLastIn();
		model.addAttribute("ultimiattori", attori);
		
		
		return "index";
	
	}

}
