package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "users") // cambiamo nome perchè in postgres user e' una parola riservata
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	
	@ManyToMany
	private List<Certificazione> certificazioni;
	

	public User() {
		this.certificazioni = new ArrayList<>();
	}
	
	public List<Certificazione> getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(List<Certificazione> certificazioni) {
		this.certificazioni = certificazioni;
	}

	public User(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public boolean addCertificazione(Certificazione c) {
		return this.certificazioni.add(c);
	}
	
	
	public boolean removeCertificazione(Certificazione c) {
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);

		if(!(c.getEsami().getData().equals(strDate)))
			return this.certificazioni.remove(c);
		
		return false;
		
	}
	
}