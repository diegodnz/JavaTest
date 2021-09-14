package com.example.demo.dto;

import java.time.LocalDate;

public class ConsultaFreteOutputDTO {
	
	private Double vlTotalFrete;
	
	private LocalDate dataPrevistaEntrega;
	
	private String cepOrigem; 
	
	private String cepDestino;
	
	public ConsultaFreteOutputDTO() {}

	public ConsultaFreteOutputDTO(Double vlTotalFrete, LocalDate dataPrevistaEntrega, String cepOrigem,
			String cepDestino) {
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
	}

	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(Double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
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

}
