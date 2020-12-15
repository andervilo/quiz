package com.quiz.arquitetura.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IRestController<E, DTOIN, DTOOUT> {	
	public ResponseEntity<Page<DTOOUT>> listAll(Pageable pageable);
	public ResponseEntity<DTOOUT> showById(@PathVariable(value = "id") Long id);	
	public ResponseEntity<DTOOUT> create(@RequestBody DTOIN object);		
	public ResponseEntity<DTOOUT> update(@PathVariable(value = "id") Long id, @RequestBody DTOIN object);
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id);

}
