package it.uniroma3.siw.spring.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Esame;

@Repository
public interface EsameRepository extends CrudRepository<Esame, Long> {
	
	public boolean existsByNome(String nome);
}
