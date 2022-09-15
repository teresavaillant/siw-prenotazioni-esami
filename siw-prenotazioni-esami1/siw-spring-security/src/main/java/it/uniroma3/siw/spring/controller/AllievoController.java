package it.uniroma3.siw.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.spring.controller.validator.UserValidator;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.UserService;


@Controller
public class AllievoController {

//	@Autowired
//	private AllievoService allievoService;
//
//	@Autowired
//	private AllievoValidator allievoValidator;
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserService userService;
	
	
	//USER 
	
	@GetMapping("/listaUtenti")
	public String getAllUsers(Model model) {
		model.addAttribute("allievi", userService.getAllUsers()); 
		return "allievi.html";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable("id")Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("allievo", user);
		return "allievo.html";
	}
	
	 @GetMapping("/allievo/{allievoId}/certificazioni")
	    public String getCertificazioni(@PathVariable("allievoId") Long allievoId, Model model) {
	        User user = userService.findById(allievoId);
	        model.addAttribute("certificazioni", user.getCertificazioni());
	        return "certificazioniUser.html";
	    }
	
	
	//ALLIEVO

//	@PostMapping("/admin/allievo")
//	public String addAllievo(@ModelAttribute(value="allievo") Allievo allievo, 
//			BindingResult bindingResult, Model model) {
//
//		this.allievoValidator.validate(allievo, bindingResult);
//
//		if (!bindingResult.hasErrors()) {
//			this.allievoService.save(allievo); // salvo un oggetto allievo
//			model.addAttribute("allievo", allievo);
//			return "allievo.html"; 
//		}
//		else {
//			model.addAttribute("allievo", allievo);
//			return "admin/allievoForm.html"; 
//		}
//	}
//	
//	@GetMapping("/allievo/{id}")
//	public String getAllievo(@PathVariable("id")Long id, Model model) {
//		Allievo allievo = allievoService.findById(id);
//		model.addAttribute("allievo", allievo);
//		return "allievo.html";
//	}
//
//	@GetMapping("/allievi")
//	public String getAllievi(Model model) {
//		List<Allievo> allievi = allievoService.findAll();
//		model.addAttribute("allievi", allievi);
//		return "allievi.html";
//	}
//
//	@GetMapping("/admin/allievoForm")
//	public String allievoForm(Model model) {
//		model.addAttribute("allievo", allievoService.createAllievo());
//		return "admin/allievoForm.html";
//	}
//	
//	@GetMapping("/admin/allievi/addCertificazione") 
//	public String addCertificazione(Model model) {
//		model.addAttribute("allievi", allievoService.findAll());
//		return "admin/selezionaAllievo.html";
//	}
}


