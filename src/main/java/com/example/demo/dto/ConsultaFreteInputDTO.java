package com.example.demo.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

public class ConsultaFreteInputDTO {
	
	@DecimalMax("10000.0")
	private Double peso;
	
	@Size(max = 64)
	private String cepOrigem;
	
	@Size(max = 64)
	private String cepDestino;
	
	@Size(max = 255)
	private String nomeDestinatario;

	public ConsultaFreteInputDTO(Double peso, String cepOrigem, String cepDestino, String nomeDestinatario) {
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

}
