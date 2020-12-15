package com.quiz.arquitetura.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.quiz.arquitetura.service.GenericService;
import com.quiz.utils.UtilsExceptionMessage;

import io.swagger.annotations.ApiOperation;

@SuppressWarnings("rawtypes")
public abstract class AbstractRestController<E, DTOIN, DTOOUT, S extends GenericService>
		implements IRestController<E, DTOIN, DTOOUT> {
	
	
	private Type entityType=null;
	private Type dtoInputType=null;
	private Type dtoOutputType=null;
		
	public AbstractRestController() {
		entityType = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		dtoInputType = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		dtoOutputType = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[2];
	}
	
	@Autowired
	private S service;
		
	@Autowired
	private ModelMapper mapper;

	@GetMapping("")
	@ApiOperation(value = "Obter Lista.")
	@Override
	public ResponseEntity<Page<DTOOUT>> listAll(Pageable pageable) {
		
		@SuppressWarnings("unchecked")
		Page<DTOOUT> page = ((Page<E>) service.findAll(pageable))
				.map((item -> mapper.map(item, dtoOutputType)));
		return ResponseEntity.ok().body(page);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	@ApiOperation(value = "Obter por ID.")
	@Override
	public ResponseEntity<DTOOUT> showById(@PathVariable Long id) {
		if (!service.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, UtilsExceptionMessage.NOT_FOUND_ERROR);
		}
		DTOOUT dtoOut = mapper.map(service.findById(id), dtoOutputType);
		return (ResponseEntity<DTOOUT>) ResponseEntity.ok().body(dtoOut);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("")
	@ApiOperation(value = "Criar.")
	@Override
	public ResponseEntity<DTOOUT> create(@Valid @RequestBody DTOIN object) {
		
		E objectEntity = mapper.map(object, entityType); 
		
		Object objectEntityReturn = service.create(objectEntity);
		
		DTOOUT dtoOut = mapper.map(objectEntityReturn, dtoOutputType);

		if (dtoOut == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, UtilsExceptionMessage.SERVER_ERROR);
		}

		return ResponseEntity.ok().body(dtoOut);
	}
	

	@SuppressWarnings("unchecked")
	@PutMapping("/{id}")
	@ApiOperation(value = "Alterar.")
	@Override
	public ResponseEntity<DTOOUT> update(Long id, @Valid @RequestBody DTOIN object) {
		if (!service.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, UtilsExceptionMessage.NOT_FOUND_ERROR);
		}
		
		E objectEntity = mapper.map(object, entityType) ;
 
		DTOOUT dtoOut = mapper.map(service.update(id, objectEntity), dtoOutputType);

		if (dtoOut == null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, UtilsExceptionMessage.SERVER_ERROR);
		}

		return ResponseEntity.ok().body(dtoOut);
	}
	
	

	@SuppressWarnings("unchecked")
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir.")
	@Override
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		
		if (!service.getRepository().existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, UtilsExceptionMessage.NOT_FOUND_ERROR);
		}
		
		if(!service.delete(id)) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, UtilsExceptionMessage.SERVER_ERROR);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public S getService() {
		return service;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Map<String, String>> errors = new HashMap<>();
		Map<String, String> errorsBody = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {

			String fieldName = ((FieldError) error).getField();

			String errorMessage = error.getDefaultMessage();

			errorsBody.put(fieldName, errorMessage);
		});
		errors.put("fieldErrors", errorsBody);
		return errors;
	}

}
