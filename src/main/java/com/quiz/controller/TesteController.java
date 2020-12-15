package com.quiz.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.arquitetura.controller.AbstractRestController;
import com.quiz.dto.PerguntaInputDTO;
import com.quiz.dto.PerguntaOutputDTO;
import com.quiz.model.Pergunta;
import com.quiz.service.PerguntaService;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/testes")
@Api(tags = "Testes")
public class TesteController extends AbstractRestController<Pergunta, PerguntaInputDTO, PerguntaOutputDTO, PerguntaService>{

}
