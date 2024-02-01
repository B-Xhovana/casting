package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.AttoreService;

//localhost:8080/areariservata
@Controller
@RequestMapping("/areariservata")
public class IndexController 
{

	@Autowired
	private AttoreService attoreService;
	
	@GetMapping
	public String getPage(Model model,
			@RequestParam("id")int id) 
	{
		model.addAttribute("attore", attoreService.getAttoreById(id));
		return "areariservata";
	}
	
	@GetMapping("/cancellaattore")
	public String cancellaAttore(@RequestParam ("id") int id) 
		{
			attoreService.cancellaAttore(attoreService.getAttoreById(id));
			return "redirect:/";
	}
}
