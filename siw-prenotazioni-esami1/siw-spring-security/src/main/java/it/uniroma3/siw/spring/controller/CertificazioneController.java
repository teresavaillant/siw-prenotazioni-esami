package it.uniroma3.siw.spring.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import it.uniroma3.siw.spring.controller.validator.CertificazioneValidator;
import it.uniroma3.siw.spring.model.Certificazione;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.service.CertificazioneService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.EsameService;



@Controller
public class CertificazioneController {
    
    @Autowired
    private CertificazioneService certificazioneService;
    
//    @Autowired
//    private AllievoService allievoService;
//    
    @Autowired
    private EsameService esameService;
    
    @Autowired
    private CertificazioneValidator certificazioneValidator;
    
    @Autowired
    private CredentialsService credentialsService;
    
    
    @PostMapping("/admin/allievo/certificazione")
    public String addCertificazione(@ModelAttribute(value="certificazione") Certificazione certificazione,
            BindingResult bindingResult, Model model) {
        
        this.certificazioneValidator.validate(certificazione, bindingResult);
        
        if(!bindingResult.hasErrors()) {
            this.certificazioneService.save(certificazione);
            model.addAttribute("certificazione", certificazione);
            model.addAttribute("esami", esameService.findAll());
            return "admin/addEsameToCertificazione.html";
        }
        else {
            model.addAttribute("certificazione", certificazione);
            return "admin/certificazioneForm.html";
        }
    }    
    
    @GetMapping("/admin/allievo/newCertificazione")
    public String newCertificazione(Model model) {
        model.addAttribute("certificazione", certificazioneService.createCertificazione());
        return "admin/certificazioneForm.html";
    }
    
    @GetMapping("/certificazione/{certificazioneId}")
    public String getCertificazione(@PathVariable("certificazioneId") Long certificazioneId, Model model) {
        model.addAttribute("certificazione", certificazioneService.findById(certificazioneId));
        return "certificazione.html";
    }
    
 
    
    @GetMapping("/certificazioni")
    public String getCertificazioni(Model model) {
        model.addAttribute("certificazioni", certificazioneService.findAll());
        return "certificazioni.html";
    }
    
    @GetMapping("/admin/certificazione/{certificazioneId}/{esameId}")
    public String addEsameToNewCertificazione(@PathVariable("certificazioneId") Long certificazioneId,
            @PathVariable("esameId") Long esameId, Model model) {
        this.certificazioneService.addEsameToCertificazione(certificazioneId, esameId);
        model.addAttribute(certificazioneService.findById(certificazioneId));
        model.addAttribute("esami", esameService.findAll());
        return "admin/addEsameToCertificazione.html";
    }
    
    @GetMapping("/admin/certificazione/{certificazioneId}/add/{esameId}")
    public String addEsameToCertificazione(@PathVariable("certificazioneId") Long certificazioneId,
            @PathVariable("esameId") Long esameId, Model model) {
        this.certificazioneService.addEsameToCertificazione(certificazioneId, esameId);
        model.addAttribute(certificazioneService.findById(certificazioneId));
        model.addAttribute("esami", esameService.findAll());
        return "admin/editCertificazione.html";
    }
    
    @GetMapping("/admin/certificazione/{certificazioneId}/removeEsame/{esameId}")
    public String removeEsameFromCertificazione(@PathVariable("certificazioneId") Long certificazioneId,
            @PathVariable("esameId") Long esameId, Model model) {
        this.certificazioneService.removeEsameFromCertificazione(certificazioneId, esameId);
        model.addAttribute(certificazioneService.findById(certificazioneId));
        model.addAttribute("esami", esameService.findAll());
        return "admin/editCertificazione.html";
    }
    
    @GetMapping("/admin/editCertificazione")
    public String chooseCertificazioneToEdit(Model model) {
        model.addAttribute("certificazioni", certificazioneService.findAll());
        return "admin/selectCertificazioneToEdit.html";
    }
    
    @GetMapping("/admin/editCertificazione/{certificazioneId}")
    public String editCertificazione(@PathVariable("certificazioneId") Long certificazioneId, Model model) {
        model.addAttribute("certificazione", certificazioneService.findById(certificazioneId));
        model.addAttribute("esami", esameService.findAll());
        return "admin/editCertificazione.html";
    }
    
    @GetMapping("/admin/removeCertificazione")
    public String chooseCertificazioneToRemove(Model model) {
        model.addAttribute("certificazioni", certificazioneService.findAll());
        return "admin/selectCertificazioneToRemove.html";
    }



   @GetMapping("/admin/removeCertificazione/{certificazioneId}")
    public String removeCertificazione(@PathVariable("certificazioneId")Long certificazioneId, Model model) {
        model.addAttribute("certificazione", certificazioneService.findById(certificazioneId));
        return "admin/removeCertificazione.html";
    }
    
//    @GetMapping("/admin/confermaRemoveCertificazione/{certificazioneId}")
//    public String confermaRemoveCertificazione(@PathVariable("certificazioneId")Long certificazioneId, Model model) {
//        certificazioneService.removeCertificazione(certificazioneId);
//        model.addAttribute("certificazioni", certificazioneService.findAll());
//        return "admin/selectCertificazioneToRemove.html";
//    }
    
    @GetMapping("/selectCertificazione")
    public String chooseCertificazione(Model model) {
        model.addAttribute("certificazioni", certificazioneService.findAll());
        return "/selectCertificazione.html";
    }
    @GetMapping("/iscrizioneEsameToCertificazione/{certificazioneId}")
    public String iscrizioneEsameToCertificazione(@PathVariable("certificazioneId") Long certificazioneId, Model model) {
        model.addAttribute("certificazione", certificazioneService.findById(certificazioneId));
        model.addAttribute("esami", esameService.findAll());
        return "/iscrizioneEsameToCertificazione.html";
    }
    
    
    
    @PostMapping("/annullaCertificazione/{id}")
	public String annullaCertificazione (@PathVariable("id") Long id, Model model) {

		User user = getCurrentUser();

		Certificazione c = this.certificazioneService.findById(id);
		if (user.removeCertificazione(c)) {
			this.certificazioneService.save(c);
			c = this.certificazioneService.findById(id);
		}

		model.addAttribute("certificazioni", user.getCertificazioni());
		return "/certificazioniUser.html";
	}
    
    
    
    @PostMapping("/registraCertificazione/{id}")
	public String registraCertificazione (@PathVariable("id") Long id, Model model) {

		User user = getCurrentUser();

		Certificazione c = this.certificazioneService.findById(id);
		if (user.addCertificazione(c)) {
			this.certificazioneService.save(c);
			c = this.certificazioneService.findById(id);
		}
	
		model.addAttribute("certificazioni", user.getCertificazioni());
		return "/certificazioniUser.html";
	}
    
    
    private User getCurrentUser () {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		User user = credentialsService.getUserDetails(username);
		return user;
	}
    
}