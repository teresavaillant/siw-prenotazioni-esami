package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.uniroma3.siw.spring.model.Certificazione;

@Repository
public interface CertificazioneRepository extends CrudRepository<Certificazione, Long>{
	
	public boolean existsByNome(String nome);
	
//	public List<Certificazione> findAllByAllievo(Allievo allievo);
	
}
