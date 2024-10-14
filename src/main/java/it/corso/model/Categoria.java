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

@Entity
@Table(name = "category")
public class Categoria {
	
	@Id
	private int id;
	
	@Column(name = "name")
	private String nome;
	
	
	@OneToMany(
			cascade = CascadeType.REFRESH,
			fetch = FetchType.LAZY,
			mappedBy = "categoria",
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


	public void setNome(String name) {
		this.nome = name;
	}


	public List<Libro> getBooks() {
		return books;
	}


	public void setBooks(List<Libro> books) {
		this.books = books;
	}


		
}
