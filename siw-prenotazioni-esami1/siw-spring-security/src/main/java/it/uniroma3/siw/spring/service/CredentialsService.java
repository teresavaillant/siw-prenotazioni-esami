package it.uniroma3.siw.spring.service;

import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.spring.model.Certificazione;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.User;
import it.uniroma3.siw.spring.repository.CredentialsRepository;

@Service
public class CredentialsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	
//	@Transactional
//	public void save(Certificazione certificazione, Allievo allievo) {
//		certificazione.setAllievo(allievo);
//		allievo.add(certificazione);
//		credentialsRepository.save(certificazione);
//	}
//	
	
	@Transactional
	public Credentials getCredentials(Long id) {
		Optional<Credentials> result = this.credentialsRepository.findById(id);
		return result.orElse(null);
	}
	
	@Transactional
	public Credentials getCredentials(String username) {
		Optional<Credentials> result = this.credentialsRepository.findByUsername(username);
		return result.orElse(null);
	}
	
	@Transactional
	public Credentials saveCredentials(Credentials credentials) {
		credentials.setRole(Credentials.DEFAULT_ROLE);
		credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
		return this.credentialsRepository.save(credentials);
	}
	
	public User getUserDetails (String username) {
		try {
			return getCredentials(username).getUser();
		} catch (NullPointerException e) {
			System.out.println("No user found. " + e.getMessage());
			return null;
		} catch (Exception e) {
			System.out.println("Generic error: " + e.getMessage());
			return null;
		}
	}
}
