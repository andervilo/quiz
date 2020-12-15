package com.quiz.controller;

import org.springframework.stereotype.Component;

import com.quiz.arquitetura.controller.AbstractRestController;
import com.quiz.model.Pergunta;
import com.quiz.service.PerguntaService;

@Component
public class PerguntaControllerExtends extends AbstractRestController<Pergunta, Pergunta, Pergunta, PerguntaService>{
	
}
