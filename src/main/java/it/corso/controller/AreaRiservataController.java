package it.corso.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import it.corso.model.Attore;
import it.corso.model.Film;
import it.corso.service.AttoreService;
import it.corso.service.FilmService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController 
{

	@Autowired
	private AttoreService attoreService;
	@Autowired
	private FilmService filmService;
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session
			) 
	{
		Attore attore = (Attore) session.getAttribute("attore");
		model.addAttribute("attorelog", session.getAttribute("attore") != null);
		model.addAttribute("attore", attore);
		//NAV BAR
		List<Film> films = filmService.getFilms();
		Map<String, List<Film>> filmPerGenere2 = filmService.getFilmByGenere(films);
		model.addAttribute("filmPerGenere2", filmPerGenere2);
		//FINE NAVBAR
		return "areariservata";
	}
	
	@GetMapping("/cancellaaccount")
	public String cancellaAttore(HttpSession session) 
		{
		Attore attore = (Attore) session.getAttribute("attore");
			attoreService.cancellaAccount(attoreService.getAttoreById(attore.getId()));
			session.invalidate();
			return "redirect:/";
	}
	
	@PostMapping
	public String gestioneModificaRitr(
			@RequestParam(name="ritratto",required = false) MultipartFile ritratto,
			HttpSession session, 
			Model model
			) {
		Attore attore = (Attore) session.getAttribute("attore");
		
		attoreService.newRitratto(attore.getId(), ritratto,session);
		model.addAttribute("attore", attore);
		return "redirect:/areariservata";
	}
	
	@PostMapping("/foto")
	public String gestioneModificaFoto(
			@RequestParam(name="foto",required = false) MultipartFile foto, 
			HttpSession session, 
			Model model
			) {
		Attore attore = (Attore) session.getAttribute("attore");
		
		attoreService.newFoto(attore.getId(), foto,session);
		model.addAttribute("attore", attore);
		return "redirect:/areariservata";
	}
	
	
	@GetMapping("/logout")
	public String gestioneLogout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
