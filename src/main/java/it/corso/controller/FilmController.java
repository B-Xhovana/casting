package it.corso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.service.FilmService;

@Controller
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public String getPage(
			@RequestParam ("id") int id,
			Model model) {
		
		model.addAttribute("film",filmService.getFilmByID(id));
	
		return "film";
	}
	
}
