package com.quiz.dto;

import java.util.ArrayList;
import java.util.List;

import com.quiz.arquitetura.dto.IEntityDTO;

import io.swagger.annotations.ApiModel;

@ApiModel
public class PerguntaOutputDTO implements IEntityDTO {

	private static final long serialVersionUID = -5013102313813193319L;

	private Long id;

	private String pergunta;

	private List<RespostaOutputDTO> respostas = new ArrayList<RespostaOutputDTO>();

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

	public List<RespostaOutputDTO> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaOutputDTO> respostas) {
		this.respostas = respostas;
	}

	@Override
	public String toString() {
		return "PerguntaOutputDTO [id=" + id + ", pergunta=" + pergunta + ", respostas=" + respostas + "]";
	}

}
