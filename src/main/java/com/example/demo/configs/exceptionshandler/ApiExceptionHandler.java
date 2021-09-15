package com.example.demo.configs.exceptionshandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.configs.exceptionshandler.exceptions.CamposException;
import com.example.demo.configs.exceptionshandler.exceptions.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(CamposException.class)
	public ResponseEntity<Object> handleCampos(CamposException ex, WebRequest request) {
		HttpStatus status = ex.getStatus();	

		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setTitulo("Um ou mais campos estão invalidos");
		erro.setDataHora(OffsetDateTime.now());
		erro.setCampos(ex.getCampos());		
		
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(NegocioException.class)	
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request) {
		HttpStatus status = ex.getStatus();	

		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setTitulo(ex.getMessage());
		erro.setDataHora(OffsetDateTime.now());				
		
		return handleExceptionInternal(ex, erro, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {		
		
		ArrayList<Campo> campos = new ArrayList<Campo>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError)error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			campos.add(new Campo(nome, mensagem));
		}
		
		Erro erro = new Erro();
		erro.setStatus(status.value());
		erro.setTitulo("Requisição com campos faltando ou preenchidos incorretamente");
		erro.setDataHora(OffsetDateTime.now());
		
		erro.setCampos(campos);
		
		return super.handleExceptionInternal(ex, erro, headers, status, request);
	
	}
	
}
