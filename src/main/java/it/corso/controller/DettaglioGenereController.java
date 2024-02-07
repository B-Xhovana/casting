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

//localhost:8080
@Controller
@RequestMapping("/dettagliogenere")
public class DettaglioGenereController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session, @RequestParam(name="gen", required = false)String genere) {
		List<Film> films = filmService.getFilms();
		
		Map<String, List<Film>> filmPerGenere = filmService.getFilmByGenere(films);
		model.addAttribute("filmPerGenere", filmPerGenere);
		
		
		model.addAttribute("attorelog", session.getAttribute("attore"));
		model.addAttribute("genere", genere);
		Map<String, List<Film>> filmPerGenere2 = filmService.getFilmByGenere(films);
		model.addAttribute("filmPerGenere2", filmPerGenere2.get(genere));
		
		return "dettagliogenere";
	
	}

}
