package com.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

}
