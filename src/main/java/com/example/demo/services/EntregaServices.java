package com.example.demo.services;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ConsultaCepDTO;
import com.example.demo.dto.ConsultaFreteInputDTO;
import com.example.demo.dto.ConsultaFreteOutputDTO;

@Service
public class EntregaServices {
	
	public ResponseEntity<ConsultaFreteOutputDTO> calcularFrete(ConsultaFreteInputDTO dadosConsulta) {
		
		String cepOrigem = dadosConsulta.getCepOrigem();
		String cepDestino = dadosConsulta.getCepDestino();
		// Obter endereços de origem e destino consumindo a api viacep
		RestTemplate restTemplate = new RestTemplate();
		// TODO Tratar exceção caso algum cep seja inválido
		ConsultaCepDTO enderecoOrigem = restTemplate.getForObject("https://viacep.com.br/ws/"
		+ cepOrigem + "/json/", ConsultaCepDTO.class);
		
		ConsultaCepDTO enderecoDestino = restTemplate.getForObject("https://viacep.com.br/ws/"
		+ cepDestino + "/json/", ConsultaCepDTO.class);
		
		int desconto = 0;
		int diasEntrega = 10;
		Double precoFrete;
		
		if (enderecoOrigem.getDdd().equals(enderecoDestino.getDdd())) {
			desconto = 50;
			diasEntrega = 1;
		} else if (enderecoOrigem.getUf().equals(enderecoDestino.getUf())) {
			desconto = 75;
			diasEntrega = 3;
		}
		
		precoFrete = dadosConsulta.getPeso() * ((100-desconto)/100.0);
		precoFrete = Math.round(precoFrete * 100.0)/100.0;
				
		ConsultaFreteOutputDTO resultado = new ConsultaFreteOutputDTO(precoFrete, LocalDate.now().plusDays(diasEntrega), cepOrigem, cepDestino);
		return new ResponseEntity<ConsultaFreteOutputDTO>(resultado, HttpStatus.OK);
		
	}
}
