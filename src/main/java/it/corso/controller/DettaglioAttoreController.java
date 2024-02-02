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
import it.corso.service.AttoreService;

//localhost:8080/dettaglioattore
@Controller
@RequestMapping("/dettaglioattore")
public class DettaglioAttoreController {
// anche film che ha fatto	
	@Autowired
	private AttoreService attoreService;
	
	@GetMapping
	public String getPage(@RequestParam("id") int id, Model model) {
		Attore attore = attoreService.getAttoreById(id);
		List<Film> film = attoreService.getFilmByAttoreId(id);
		model.addAttribute("attore", attore);
		model.addAttribute("film", film);
		return "dettaglioattore";
	}
	
}