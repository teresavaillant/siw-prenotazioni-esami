package it.uniroma3.siw.spring.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Certificazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String descrizione;
	
//	@ManyToOne
//	private Allievo allievo;
	
	@ManyToOne
	private Esame esami;
	
	public Certificazione(Long id, String nome, String descrizione) {
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		//this.allievo = allievo;
	}

	public Certificazione() {
		this.esami = esami;
	}

	public Esame getEsami() {
		return esami;
	}

	public void setEsami(Esame esami) {
		this.esami = esami;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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

//	public Allievo getAllievo() {
//		return allievo;
//	}
//
//	public void setAllievo(Allievo allievo) {
//		this.allievo = allievo;
//	}
	
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o.getClass() != Certificazione.class)
			return false;
		Certificazione that = (Certificazione)o;
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public String toString() {
		return this.nome + " " + this.descrizione;
	}
}
