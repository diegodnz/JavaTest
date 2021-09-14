package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConsultaFreteInputDTO;
import com.example.demo.dto.ConsultaFreteOutputDTO;
import com.example.demo.services.EntregaServices;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaServices entregaServices; 
	
	@PostMapping("/consultar-frete")
	public ResponseEntity<ConsultaFreteOutputDTO> consultarFrete(@Valid @RequestBody ConsultaFreteInputDTO consulta) {
		return entregaServices.calcularFrete(consulta);
	}
}
