package it.uniroma3.siw.spring.service;

import java.util.ArrayList;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Esame;
import it.uniroma3.siw.spring.repository.EsameRepository;

@Service
public class EsameService {
	
	@Autowired
	private EsameRepository esameRepository;
	
	@Transactional
	public void save(Esame esame) {
		esameRepository.save(esame);
	}
	
	@Transactional
	public void saveAll(List<Esame> esami) {
		esameRepository.saveAll(esami);
	}
	
	@Transactional
	public void deleteById(Long id) {
		esameRepository.deleteById(id);
	}
	
	@Transactional
	public void delete(Esame esame) {
		esameRepository.delete(esame);
	}
	
	public Esame findById(Long id) {
		return esameRepository.findById(id).get();
	}
	
	public List<Esame> findAll() {
		List<Esame> esami = new ArrayList<>();
		for(Esame e : esameRepository.findAll())
			esami.add(e);
		return esami;
	}
	
	public boolean alreadyExists(Esame esame) {
		return esameRepository.existsByNome(esame.getNome());
	}
	
	public List<Esame> findEsamiNotInCertificazione(List<Esame> esamiPresenti) {
		List<Esame> esami = this.findAll();
		for(Esame e : esamiPresenti)
			esami.remove(e);
		return esami;
	}

}
