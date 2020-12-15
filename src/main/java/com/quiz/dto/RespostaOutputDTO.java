package com.quiz.dto;

import com.quiz.arquitetura.dto.IEntityDTO;

public class RespostaOutputDTO implements IEntityDTO {

	private static final long serialVersionUID = -4309381474399017266L;

	private Long id;

	private String resposta;

	private Boolean selecionada = false;

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

	public Boolean getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Boolean selecionada) {
		this.selecionada = selecionada;
	}

	@Override
	public String toString() {
		return "RespostaOutputDTO [id=" + id + ", resposta=" + resposta + ", selecionada=" + selecionada + "]";
	}

}
