package com.example.demo.configs.exceptionshandler.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.demo.configs.exceptionshandler.Campo;

public class CamposException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private HttpStatus status;
	
	private List<Campo> campos;

	public CamposException(HttpStatus status, List<Campo> campos) {
		super("Campos inválidos");
		this.status = status;
		this.campos = campos;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}
}
