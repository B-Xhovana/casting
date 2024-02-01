package it.corso.controller;



import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Film;
import it.corso.service.FilmService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public String getPage(Model model) {
		List<Film> films = filmService.getFilms();
		Map<String, List<Film>> filmPerGenere = filmService.getFilmByGenere(films);
	          
		
		model.addAttribute("filmPerGenere", filmPerGenere);
		
		
		
	return "index";
	}

}
