package it.uniroma3.siw.spring.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
//@Table(name = "allievo")
//public class Allievo {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//		
//	private String nome;
//		
//	private String cognome;
//	
//	private String nazionalita;
//	
//	@Column(name="matricola", nullable=false, length=6)
//	private int matricola;
//	
//	@OneToMany(mappedBy = "allievo", fetch=FetchType.LAZY)
//	private List<Certificazione> certificati;
//	
//	@OneToMany(mappedBy = "allievo", fetch=FetchType.LAZY)
//	private List<Esame> esami;
//	
//	
//	public Allievo(Long id, String nome, String cognome, int matricola, List<Certificazione> certificati, List<Esame> esami) {
//		this.id = id;
//		this.cognome = cognome;
//		this.nome = nome;
//		this.matricola = matricola;
//		this.certificati = certificati;
//		this.esami=esami;
//	}
//
//	public Allievo() {
//		this.certificati = new ArrayList<>();
//		this.esami = new ArrayList<>();
//	}
//
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}
//
//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}
//	
//	public int getMatricola() {
//		return matricola;
//	}
//
//	public void setMatricola(int matricola) {
//		this.matricola = matricola;
//	}
//
//	public String getNazionalita() {
//		return nazionalita;
//	}
//
//	public void setNazionalita(String nazionalita) {
//		this.nazionalita = nazionalita;
//	}
//
//	public List<Certificazione> getCertificati() {
//		return certificati;
//	}
//
//	public void setCertificati(List<Certificazione> certificati) {
//		this.certificati = certificati;
//	}
//	
//	public List<Esame> getEsami() {
//		return esami;
//	}
//
//	public void setEsami(List<Esame> esami) {
//		this.esami = esami;
//	}
//	
//	
//	public void addCertificato(Certificazione certificato) {
//		this.certificati.add(certificato);
//	}
//	
//	public void removeCertificato(Certificazione certificato) {
//		this.certificati.remove(certificato);
//	}
//	
//	public void addEsame(Esame esame) {
//		this.esami.add(esame);
//	}
//	
//	public void removeEsame(Esame esame) {
//		this.esami.remove(esame);
//	}
//	
//	
//	@Override
//	public int hashCode() {
//		return this.getNome().hashCode() +
//				this.getCognome().hashCode() +
//				this.getMatricola() + 
//				this.getNazionalita().hashCode();
//	}
//	
//	@Override
//	public boolean equals(Object o) {
//		if(o.getClass() != Allievo.class)
//			return false;
//		Allievo that = (Allievo)o;
//		return this.getNome().equals(that.getNome()) &&
//				this.getCognome().equals(that.getCognome()) &&
//				this.getMatricola() == that.getMatricola() &&
//				this.getNazionalita().equals(that.getNazionalita());
//	}
//	
//	@Override
//	public String toString() {
//		return this.nome + " " + this.cognome + " " + this.matricola + " " + this.nazionalita;
//	}
//
//	public void add(Certificazione certificato) {
//		this.certificati.add(certificato);
//	}
//}
