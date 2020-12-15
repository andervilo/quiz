package com.quiz.service;

import org.springframework.stereotype.Service;

import com.quiz.arquitetura.service.GenericServiceimpl;
import com.quiz.model.Resposta;
import com.quiz.repository.RespostaRepository;

@Service
public class RespostaService extends GenericServiceimpl<Resposta, RespostaRepository>{

}
