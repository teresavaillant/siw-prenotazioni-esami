package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Certificazione;
import it.uniroma3.siw.spring.service.CertificazioneService;

@Component
public class CertificazioneValidator implements Validator {
	
	@Autowired
	private CertificazioneService certificazioneService;

		
	@Override
	public void validate(Object o, Errors errors) {
		if(this.certificazioneService.alreadyExists((Certificazione)o))
			errors.reject("certificazione.duplicato");
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Certificazione.class.equals(clazz);
	}
}
