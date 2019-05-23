package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="public", name="book")
public class Book {	
	@Id
	@GeneratedValue(generator = "book_id_book_seq", strategy=GenerationType.AUTO)
	@SequenceGenerator(name = "book_id_book_seq", sequenceName = "public.book_id_book_seq", allocationSize = 1)
	@Column(name = "id_book")
	private Integer idLibro;
	
	@Column(name="title")
	private String titulo;
	
	@Column(name="author")
	private String autor;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="genre")
	private String genero;
	
	@Column(name="stock")
	private Integer existencias;
	
	
	public Book() {
		super();
	}

	public Book(Integer idLibro, String titulo, String autor, String isbn, Integer existencias, String genero) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.existencias = existencias;
		this.genero = genero;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getExistencias() {
		return existencias;
	}

	public void setExistencias(Integer existencias) {
		this.existencias = existencias;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	/*public String getActivoDelegate() {
		if(this.bActivo == null) return "";
		else {
			return bActivo == true ?"Activo":"Inactivo";
		}
	}*/
	
}
