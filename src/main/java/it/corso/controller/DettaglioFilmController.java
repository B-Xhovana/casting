package it.corso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Attore;
import it.corso.model.Film;
import it.corso.service.FilmService;

// localhost:8080/dettagliofilm
@Controller
@RequestMapping("/dettagliofilm")
public class DettaglioFilmController {

	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public String getPage(
			@RequestParam ("id") int id,
			Model model) {
		Film film = filmService.getFilmByID(id);
		model.addAttribute("film", film);
		
		List<Attore> attore = filmService.getCastByFilmId(id);
		model.addAttribute("attore", attore);
	
		return "dettagliofilm";
	}
	
}
