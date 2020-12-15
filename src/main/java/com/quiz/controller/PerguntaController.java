package com.quiz.controller;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.arquitetura.controller.IRestController;
import com.quiz.dto.PerguntaInputDTO;
import com.quiz.dto.PerguntaOutputDTO;
import com.quiz.model.Pergunta;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/perguntas")
@Api(tags = "Perguntas")
public class PerguntaController implements IRestController<PerguntaInputDTO, PerguntaInputDTO, PerguntaOutputDTO>{
	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private PerguntaControllerExtends service;
	
	private Logger logger = LoggerFactory.getLogger(PerguntaController.class);

	@GetMapping("")
	@ApiOperation(value = "Obter lista.")
	@Override
	public ResponseEntity<Page<PerguntaOutputDTO>> listAll(Pageable pageable) {
		Page<PerguntaOutputDTO> entities = ((Page<Pergunta>) service.listAll(pageable).getBody())
				.map((pergunta -> mapper.map(pergunta, PerguntaOutputDTO.class)));

		return ResponseEntity.ok(entities);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Obter por ID.")
	@Override
	public ResponseEntity<PerguntaOutputDTO> showById(Long id) {		
		return ResponseEntity.ok(mapper.map(service.showById(id).getBody(), PerguntaOutputDTO.class));
	}

	@PostMapping("")
	@ApiOperation(value = "Criar.")
	@Override
	public ResponseEntity<PerguntaOutputDTO> create(PerguntaInputDTO object) {
		Pergunta pergunta = mapper.map(object, Pergunta.class);
		PerguntaOutputDTO perguntaOutputDTO = mapper.map(service.create(pergunta).getBody(), PerguntaOutputDTO.class);
		logger.info("create() com body {} do tipo {} corpo retorno {} do tipo {}", object, PerguntaInputDTO.class, perguntaOutputDTO, PerguntaOutputDTO.class);
		return ResponseEntity.ok(perguntaOutputDTO);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alterar.")
	@Override
	public ResponseEntity<PerguntaOutputDTO> update(Long id, PerguntaInputDTO object) {
		Pergunta pergunta = mapper.map(object, Pergunta.class);
		PerguntaOutputDTO perguntaOutputDTO = mapper.map(service.update(id,pergunta).getBody(), PerguntaOutputDTO.class);
		return ResponseEntity.ok(perguntaOutputDTO);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir.")
	@Override
	public ResponseEntity<HttpStatus> delete(Long id) {
		return service.delete(id);
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
