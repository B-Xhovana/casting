package it.corso.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import it.corso.model.Attore;
import it.corso.service.AttoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/registrazione")
public class FormController {
	
	@Autowired
	private AttoreService attoreService;
	
	@GetMapping
	public String getPage(Model model) {
		Attore attore = new Attore();
		model.addAttribute("attore", attore);
		return "form";
	}
	
	@PostMapping
	public String formManager(
			//@ModelAttribute Attore attore,
			@RequestParam ("nome") String nome,
			@RequestParam("cognome") String cognome,
			@RequestParam("dataNascita") LocalDate dataNascita,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
		    @RequestParam(name="ritratto",required = false) MultipartFile ritratto,
		    @RequestParam(name="foto",required = false) MultipartFile foto) {
		
		if (attoreService.checkAttore(email)!=null) {
			return "redirect:/registrazione"; // aggiungere nel fe messaggio email già associata ad altro utente
		}
		
		attoreService.registraAttore(nome, cognome, dataNascita, password, email, ritratto, foto);
		return "redirect:/";
		
	}
	
	
}
