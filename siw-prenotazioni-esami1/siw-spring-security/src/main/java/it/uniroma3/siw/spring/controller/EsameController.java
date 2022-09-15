package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.spring.controller.validator.EsameValidator;
import it.uniroma3.siw.spring.model.Esame;
import it.uniroma3.siw.spring.service.EsameService;

@Controller
public class EsameController {
	
	@Autowired
	private EsameService esameService;
	
	@Autowired
	private EsameValidator esameValidator;
	
	
	@GetMapping("esame/{esameId}")
	public String getEsame(@PathVariable("esameId") Long esameId, Model model) {
		model.addAttribute("esame", esameService.findById(esameId));
		return "esame.html";
	}
	
	@GetMapping("/admin/esameForm")
	public String esameForm(Model model) {
		Esame e = new Esame();
		model.addAttribute("esame", e);
		return "admin/esameForm.html";
	}
	
	@PostMapping("/admin/esame")
	public String addEsame(@ModelAttribute(value="esame") Esame esame, 
			BindingResult bindingResult, Model model) {
		
		this.esameValidator.validate(esame, bindingResult);
		
		if(!bindingResult.hasErrors()) {
			this.esameService.save(esame);
			model.addAttribute("esame", esame);
			return "esame.html";
		}
		else {
			model.addAttribute("esame", esame);
			return "admin/esameForm.html";
		}
	}
}
