package com.quiz.dto;

import java.util.ArrayList;
import java.util.List;

import com.quiz.arquitetura.dto.IEntityDTO;

public class PerguntaInputDTO implements IEntityDTO {

	private static final long serialVersionUID = 6212305277414561181L;

	private Long id;

	private String pergunta;

	private Integer quantidadeAlternativas = 5;

	private List<RespostaInputDTO> respostas = new ArrayList<RespostaInputDTO>();

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

	public List<RespostaInputDTO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaInputDTO> respostas) {
		this.respostas = respostas;
	}

	public Integer getQuantidadeAlternativas() {
		return quantidadeAlternativas;
	}

	public void setQuantidadeAlternativas(Integer quantidadeAlternativas) {
		this.quantidadeAlternativas = quantidadeAlternativas;
	}

	@Override
	public String toString() {
		return "PerguntaInputDTO [id=" + id + ", pergunta=" + pergunta + ", quantidadeAlternativas="
				+ quantidadeAlternativas + ", respostas=" + respostas + "]";
	}

}
