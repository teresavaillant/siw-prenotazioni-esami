package it.uniroma3.siw.spring.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.spring.model.Certificazione;

//@Service
//public class AllievoService {
//	
//	@Autowired
//	protected AllievoRepository allievoRepository;
//	
	
	 /**
     * This method retrieves a Student from the DB based on its ID.
     * @param id the id of the Student to retrieve from the DB
     * @return the retrieved Student, or null if no User with the passed ID could be found in the DB
     */
//	@Transactional
//	public Allievo getAllievo(Long id) {
//		Optional<Allievo> result = this.allievoRepository.findById(id);
//		return result.orElse(null);
//	}
	
	/**
     * This method saves a Student in the DB.
     * @param user the Student to save into the DB
     * @return the saved Student
     * @throws DataIntegrityViolationException if a Student with the same username
     *                              as the passed Student already exists in the DB
     */
//	@Transactional
//	public Allievo saveAllievo(Allievo allievo) {
//		return this.allievoRepository.save(allievo);
//	}
	
	/**
     * This method retrieves all Student from the DB.
     * @return a List with all the retrieved Student
     */
//	@Transactional
//	public List<Allievo> getAllAllievi() {
//		List<Allievo> allievi = new ArrayList<>();
//		Iterable<Allievo> it = this.allievoRepository.findAll();
//		for(Allievo allievo : it) {
//			allievi.add(allievo);
//		}
//		return allievi;
//	}
	
//	@Transactional 
//	public Allievo findById(Long id) {
//		return allievoRepository.findById(id).get();
//	}
//
//	public void removeEsameFromAllievo(Allievo allievo, Certificazione cer) {
//		allievo.removeCertificato(cer);
//		allievoRepository.save(allievo);
//	}
//
//	@Transactional
//	public void save(Allievo allievo) {
//		allievoRepository.save(allievo);
//	}
//
//	public List<Allievo> findAll() {
//		List<Allievo> allievo = new ArrayList<>();
//		for(Allievo a : allievoRepository.findAll()) 
//			allievo.add(a);
//		return allievo;
//	}
//
//	public Allievo createAllievo() {
//		return new Allievo();
//	}
//}
