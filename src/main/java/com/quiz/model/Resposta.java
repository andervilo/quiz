package com.quiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quiz.arquitetura.entity.BaseEntity;

@Entity
public class Resposta{

	private static final long serialVersionUID = 6888701467332558234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	private String resposta;

	private Boolean certa = false;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "pergunta_id", nullable = false)
	private Pergunta pergunta;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Boolean getCerta() {
		return certa;
	}

	public void setCerta(Boolean certa) {
		this.certa = certa;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

}
