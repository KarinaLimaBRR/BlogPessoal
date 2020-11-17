package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem") 
public class PostagemModel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull //não aceitar tabela vazia
	@Size(min=5,max=100) // tamanho do texto
	private String titulo;

	@NotNull
	private int ano;
	
	@NotNull //não aceitar tabela vazia
	@Size(min=10,max=500) // tamanho do texto
	private String texto;
	 
	@Temporal(TemporalType.TIMESTAMP) // tipo de data
	private Date data= new java.sql.Date(System.currentTimeMillis());

	@ManyToOne 
	@JsonIgnoreProperties ("postagem")
	private Tema tema;
	
	
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

	
}
