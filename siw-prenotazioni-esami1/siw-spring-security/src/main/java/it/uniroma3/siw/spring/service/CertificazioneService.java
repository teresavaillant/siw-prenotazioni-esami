package it.uniroma3.siw.spring.service;



import java.util.ArrayList;

import java.util.List;



import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.uniroma3.siw.spring.model.Certificazione;
import it.uniroma3.siw.spring.model.Esame;
import it.uniroma3.siw.spring.repository.CertificazioneRepository;



@Service
public class CertificazioneService {

	@Autowired
	private CertificazioneRepository certificazioneRepository;

//	@Autowired
//	private AllievoService allievoService;

	@Autowired
	private EsameService esameService;


	//    @Transactional
	//    public void save(Certificazione cer, Allievo allievo) {
	//        cer.setAllievo(allievo);
	//        allievo.addCertificato(cer);
	//        certificazioneRepository.save(cer);
	//    }

	@Transactional
	public void save(Certificazione cer) {
		certificazioneRepository.save(cer);
	}

	@Transactional
	public void saveAll(List<Certificazione> certificati) {
		certificazioneRepository.saveAll(certificati);
	}

	@Transactional
	public void deletedById(Long id) {
		certificazioneRepository.deleteById(id);
	}

	@Transactional
	public void deleted(Certificazione cer) {
		certificazioneRepository.delete(cer);
	}
	
	public Certificazione findById(Long id) {
		return certificazioneRepository.findById(id).get();
	}

	public List<Certificazione> findAll() {
		List<Certificazione> certificati = new ArrayList<>();
		for(Certificazione c : certificazioneRepository.findAll())
			certificati.add(c);
		return certificati;
	}

	public boolean alreadyExists(Certificazione cer) {
		return certificazioneRepository.existsByNome(cer.getNome());
	}

//	public List<Certificazione> findAllByAllievo(Allievo allievo) {
//		List<Certificazione> certificati = new ArrayList<Certificazione>();
//		for(Certificazione c : certificazioneRepository.findAllByAllievo(allievo))
//			certificati.add(c);
//		return certificati;
//	}

	@Transactional
	public void addEsame(Certificazione cer, Esame esame) {
		cer.setEsami(esame);
		certificazioneRepository.save(cer);
	}



	@Transactional
	public void removeEsameFromCertificazione(Long certificazioneId, Long esameId) {
		Certificazione cer = this.findById(certificazioneId);
		Esame esame = esameService.findById(esameId);
		cer.setEsami(null);
		certificazioneRepository.save(cer);
	}

	//    public Esame esami findEsamiNotInCertificazione(Long idCertificazione) {
	//        Certificazione cer = this.findById(idCertificazione);
	//        return esameService.findEsamiNotInCertificazione(cer.getEsami());
	//    }
	
	public Certificazione createCertificazione() {
		return new Certificazione();
	}

	@Transactional
	public void addEsameToCertificazione(Long certificazioneId, Long esameId) {
		Certificazione cer = this.findById(certificazioneId);
		Esame esame = esameService.findById(esameId);
		cer.setEsami(esame);
		certificazioneRepository.save(cer);
	}



//	@Transactional
//	public void removeCertificazione(Long certificazioneId, Long esameId) {
//		Certificazione cer = this.findById(certificazioneId);
//		Esame esami = esameService.findById(esameId);
//		cer.setEsami(esami);
//		allievoService.removeEsameFromAllievo(cer.getAllievo(), cer);
//		this.deleted(cer);
//	}
}