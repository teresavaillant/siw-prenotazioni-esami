package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Esame;
import it.uniroma3.siw.spring.service.EsameService;

@Component
public class EsameValidator implements Validator {
	
	@Autowired
	private EsameService esameService;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Esame.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		if(this.esameService.alreadyExists((Esame)o))
			errors.reject("esame.duplicato");
	}

}
