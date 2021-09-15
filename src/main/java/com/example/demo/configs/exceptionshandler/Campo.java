package com.example.demo.configs.exceptionshandler;

import io.swagger.annotations.ApiModelProperty;

public class Campo {

	@ApiModelProperty(position = 0)
	private String nome;
	
	@ApiModelProperty(position = 1)
	private String mensagem;

	public Campo(String nome, String mensagem) {
		super();
		this.nome = nome;
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}