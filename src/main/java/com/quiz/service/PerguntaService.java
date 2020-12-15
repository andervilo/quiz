package com.quiz.service;

import org.springframework.stereotype.Service;

import com.quiz.arquitetura.service.GenericServiceimpl;
import com.quiz.model.Pergunta;
import com.quiz.repository.PerguntaRepository;

@Service
public class PerguntaService extends GenericServiceimpl<Pergunta, PerguntaRepository>{

}
