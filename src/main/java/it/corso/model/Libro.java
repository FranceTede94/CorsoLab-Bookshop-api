package it.corso.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Libro {
	
	@Id
	private int id;
	
	@Column(name = "title")
	private String titolo;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Autore autore;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Categoria categoria;
	
	@Column(name = "price")
	private float prezzo;
	

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String title) {
		this.titolo = title;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float price) {
		this.prezzo = price;
	}

		

}

