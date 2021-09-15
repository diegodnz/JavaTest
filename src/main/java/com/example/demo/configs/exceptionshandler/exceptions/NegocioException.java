package com.example.demo.configs.exceptionshandler.exceptions;

import org.springframework.http.HttpStatus;

public class NegocioException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private HttpStatus status;

	public NegocioException(HttpStatus status, String mensagem) {
		super(mensagem);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
