package com.example.demo.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Consulta {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotNull
	@DecimalMax("100000.0")
	Double peso;
	
	@NotBlank
	@Size(max = 64)
	String cepOrigem;
	
	@NotBlank
	@Size(max = 64)
	String cepDestino;
	
	@Size(max = 255)
	String nomeDestinatario;
	
	@NotNull
	@DecimalMax("100000.0")
	Double vlTotalFrete;
	
	@NotNull
	LocalDate dataPrevistaEntrega;
	
	@NotNull
	LocalDate dataConsulta;
	
	public Consulta() {}

	public Consulta(@NotNull @DecimalMax("100000.0") Double peso, @NotBlank @Size(max = 64) String cepOrigem,
			@NotBlank @Size(max = 64) String cepDestino, @Size(max = 255) String nomeDestinatario,
			@NotNull @DecimalMax("100000.0") Double vlTotalFrete, @NotNull LocalDate dataPrevistaEntrega,
			@NotNull LocalDate dataConsulta) {
		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConsulta = dataConsulta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
