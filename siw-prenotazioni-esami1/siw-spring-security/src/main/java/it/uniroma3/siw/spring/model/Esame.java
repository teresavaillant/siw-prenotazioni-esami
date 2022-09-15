package it.uniroma3.siw.spring.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Esame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String descrizione;
	
	private String professore;
	
	private String data;

	private int cfu;

	
	@OneToMany(mappedBy="esami")
	private List<Certificazione> certificazioni;
	
	public Esame() {
		this.certificazioni = new ArrayList<>();
	}
	
	public Esame(String nome, String descrizione, String professore, String data, int cfu) {
		this.cfu = cfu;
		this.nome = nome;
		this.descrizione = descrizione;
		this.professore = professore;
		this.data = data;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public List<Certificazione> getCertificazioni() {
		return certificazioni;
	}

	public void setCertificazioni(List<Certificazione> certificazioni) {
		this.certificazioni = certificazioni;
	}

	public String getProfessore() {
		return professore;
	}

	public void setProfessore(String professore) {
		this.professore = professore;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(descrizione, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		return Objects.equals(descrizione, other.descrizione) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Esame [nome=" + nome + ", descrizione=" + descrizione + ", data=" + data + ", cfu=" + cfu + "]";
	}
}
