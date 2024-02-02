package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Attore;
import it.corso.service.AttoreService;
import jakarta.servlet.http.HttpSession;

//localhost:8080/areariservata
@Controller
@RequestMapping("/areariservata")
public class AreaRiservataController 
{

	@Autowired
	private AttoreService attoreService;
	
	@GetMapping
	public String getPage(
			Model model,
			HttpSession session
			) 
	{
		Attore attore = (Attore) session.getAttribute("attore");
		model.addAttribute("attore", attore);
		return "areariservata";
	}
	
	@GetMapping("/cancellaattore")
	public String cancellaAttore(@RequestParam ("id") int id) 
		{
			attoreService.cancellaAttore(attoreService.getAttoreById(id));
			return "redirect:/";
	}
	
	@PostMapping
	public String gestioneModifica(HttpSession session,
			@RequestParam(name="ritratto",required = false) MultipartFile ritratto,
            @RequestParam(name="foto",required = false) MultipartFile foto) {
		
				attoreService.modificaFoto(session, ritratto, foto);
				return "redirect:/riservata";
		}
}
