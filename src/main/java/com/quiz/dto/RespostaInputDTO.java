package com.quiz.dto;

import com.quiz.arquitetura.dto.IEntityDTO;

public class RespostaInputDTO implements IEntityDTO {

	private static final long serialVersionUID = -2826298861747754503L;

	private Long id = 0L;

	private String resposta;

	private Boolean certa = false;

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

	@Override
	public String toString() {
		return "RespostaInputDTO [id=" + id + ", resposta=" + resposta + ", certa=" + certa + "]";
	}

}
