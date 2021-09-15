package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configs.exceptionshandler.Erro;
import com.example.demo.dto.ConsultaFreteInputDTO;
import com.example.demo.dto.ConsultaFreteOutputDTO;
import com.example.demo.services.EntregaServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaServices entregaServices; 
	
	// ** Consultar Frete **
	@ApiOperation(value = "Consultar Frete", notes = "Calcula o preço do frete com base no peso, cepOrigem e cepDestino informados no corpo da requisição", authorizations = {
			@Authorization(value = "JWT") })
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = ConsultaFreteOutputDTO.class, message = "Retorna os dados com o preço do frete calculado"),
			@ApiResponse(code = 400, response = Erro.class, message = "Caso haja campos preechidos incorretamente, serão retornadas mensagens de erro para cada campo incorreto com o nome e descrição do mesmo"),
			@ApiResponse(code = 503, response = Erro.class, message = "Caso o serviço viacep não esteja disponível") })	
	@PostMapping("/consultar-frete")
	public ResponseEntity<ConsultaFreteOutputDTO> consultarFrete(@Valid @RequestBody ConsultaFreteInputDTO consulta) {
		return entregaServices.calcularFrete(consulta);
	}
}
