package com.rxl.socialbooks.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="O nome do Autor nao pode ser vazio.")
	private String nome; 
	@JsonInclude(Include.NON_NULL)

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message="A data de nascimento obrigatório")
	private String dataNacimento;
		
	@JsonInclude(Include.NON_NULL)
	private String nacionalide;
	
	@OneToMany(mappedBy= "autor")
	@JsonIgnore
	private List<Livro> livros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(String dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public String getNacionalide() {
		return nacionalide;
	}

	public void setNacionalide(String nacionalide) {
		this.nacionalide = nacionalide;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
