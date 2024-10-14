package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity // class POJO che rispecchia un'entità
@Table(name = "author") // mappatura con la tabella author del db
public class Autore {
	
	@Id
	private int id;
	
	@Column(name = "name")
	private String nome;
	
	@Column(name = "lastname")
	private String cognome;
	
	@OneToMany(
		cascade = CascadeType.REFRESH,
		fetch = FetchType.LAZY,
		mappedBy = "autore",
		orphanRemoval = true	
	)
	
	@JsonIgnore
	private List<Libro> books = new ArrayList<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public List<Libro> getBooks() {
		return books;
	}


	public void setBooks(List<Libro> books) {
		this.books = books;
	}

}

