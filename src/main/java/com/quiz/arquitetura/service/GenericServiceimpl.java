package com.quiz.arquitetura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.arquitetura.entity.BaseEntity;

public class GenericServiceimpl<E, R extends JpaRepository<E, Long>>
		implements GenericService<E, R> {

	@Autowired
	private R repository;

	@Override
	public Page<?> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public E findById(Long id) {
		try {
			return repository.findById(id).get();
		}  catch (Exception e) {
			return null;
		}
	}

	@Override
	public E create(E object) {
		try {
			return repository.saveAndFlush(object);
		}  catch (Exception e) {
			System.out.println("Erro ao criar: "+e.getMessage());
			return null;
		}
	}

	@Override
	public E update(Long id, E object) {
		try {
			return repository.saveAndFlush(object);
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public boolean delete(Long id) {
        try {
        	repository.deleteById(id);			
			return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public JpaRepository<E, Long> getRepository() {
		return this.repository;
	}

}
