package com.quiz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.quiz.arquitetura.entity.BaseEntity;

@Entity
public class Pergunta{

	private static final long serialVersionUID = 6888701467332558234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	private String pergunta;

	private Integer quantidadeAlternativas = 5;

	@OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
	private List<Resposta> respostas = new ArrayList<Resposta>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		for (Resposta resposta : respostas) {
			resposta.setPergunta(this);
		}
		this.respostas = respostas;
	}

	public Integer getQuantidadeAlternativas() {
		return quantidadeAlternativas;
	}

	public void setQuantidadeAlternativas(Integer quantidadeAlternativas) {
		this.quantidadeAlternativas = quantidadeAlternativas;
	}

}
