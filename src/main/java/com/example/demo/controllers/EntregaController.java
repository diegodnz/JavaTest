package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ConsultaFreteInputDTO;
import com.example.demo.dto.ConsultaFreteOutputDTO;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@PostMapping("/consultar")
	public ResponseEntity<ConsultaFreteOutputDTO> consultarFrete(@Valid @RequestBody ConsultaFreteInputDTO consulta) {
		// TODO implementar regras de negocio no service
	}
}
