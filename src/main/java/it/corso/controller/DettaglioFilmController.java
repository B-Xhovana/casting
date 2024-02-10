package it.corso.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Film;
import it.corso.service.FilmService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/dettagliofilm")
public class DettaglioFilmController {

	@Autowired
	private FilmService filmService;
	
	
	@GetMapping
	public String getPage(
			@RequestParam ("id")int id,
			Model model, HttpSession session) {
		
		model.addAttribute("film",filmService.getFilmById(id));
		model.addAttribute("cast", filmService.getCast(id));
		//NAV BAR
		List<Film> films = filmService.getFilms();
		Map<String, List<Film>> filmPerGenere2 = filmService.getFilmByGenere(films);
		model.addAttribute("filmPerGenere2", filmPerGenere2);
		model.addAttribute("attorelog", session.getAttribute("attore") != null);
		//FINE NAVBAR
		return "dettagliofilm";
	}
	
}
