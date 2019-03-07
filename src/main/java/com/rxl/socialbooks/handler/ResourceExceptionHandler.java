package com.rxl.socialbooks.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rxl.socialbooks.domain.Erros;
import com.rxl.socialbooks.service.exception.AutorExistenteException;
import com.rxl.socialbooks.service.exception.AutorNaoEncontradoException;
import com.rxl.socialbooks.service.exception.LivroNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<Erros> handlerLivroNaoEncontradoException(LivroNaoEncontradoException ex, HttpServletRequest request){
		Erros erros = new Erros();
		erros.setTitulo("O livro nao pode ser encontrado");
		erros.setStatus(404L);
		erros.setMensagem("http://erros.rxl.com/404");
		erros.setTimesTamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
	}
	
	@ExceptionHandler(AutorNaoEncontradoException.class)
	public ResponseEntity<Erros> handlerAutorNaoEncontradoException(AutorNaoEncontradoException ex, HttpServletRequest request){
		Erros erros = new Erros(); 
		erros.setTitulo("O Autor nao pode ser encontrado");
		erros.setStatus(404L);
		erros.setMensagem("http://erros.rxl.com/404");
		erros.setTimesTamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Erros> DataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){
		Erros erros = new Erros();
		erros.setTitulo("Recurso Inválido");
		erros.setStatus(new Long(HttpStatus.BAD_REQUEST.value()));
		erros.setMensagem("http://erros.rxl.com/400");
		erros.setTimesTamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Erros> DataIntegrityViolationException(MethodArgumentNotValidException ex, HttpServletRequest request){
		Erros erros = new Erros();
		erros.setTitulo("Dados Invalidos");
		erros.setStatus(new Long(HttpStatus.BAD_REQUEST.value()));
		erros.setMensagem(ex.getMessage());
		erros.setTimesTamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}

	@ExceptionHandler(AutorExistenteException.class)
	public ResponseEntity<Erros> AutorExistente(AutorExistenteException ex, HttpServletRequest request){
		Erros erros = new Erros();
		erros.setTitulo("Autor ja existente");
		erros.setStatus(409L);
		erros.setMensagem("http://erros.rxl.com/404");
		erros.setTimesTamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erros);
	}
}
