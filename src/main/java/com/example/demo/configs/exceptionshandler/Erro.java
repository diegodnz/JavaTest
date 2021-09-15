package com.example.demo.configs.exceptionshandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Erro {

	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private Boolean possuiCampos;
	private List<Campo> campos;

	public Erro() {
		possuiCampos = false;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Campo> getCampos() {
		return campos;
	}

	public void setCampos(List<Campo> campos) {
		this.possuiCampos = true;
		this.campos = campos;
	}

	public Boolean getPossuiCampos() {
		return possuiCampos;
	}

	public void setPossuiCampos(Boolean possuiCampos) {
		this.possuiCampos = possuiCampos;
	}

}
