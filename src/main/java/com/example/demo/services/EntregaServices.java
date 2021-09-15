package com.example.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.configs.exceptionshandler.Campo;
import com.example.demo.configs.exceptionshandler.exceptions.CamposException;
import com.example.demo.configs.exceptionshandler.exceptions.NegocioException;
import com.example.demo.dto.ConsultaCepDTO;
import com.example.demo.dto.ConsultaFreteInputDTO;
import com.example.demo.dto.ConsultaFreteOutputDTO;

@Service
public class EntregaServices {
	
	protected RestTemplate restTemplate = new RestTemplate();
	
	/**
     * Este método obtém informações de endereço a partir de um cep, fazendo requisição na api viacep
     * @param nomeCampo - String utilizada para representar qual cep está sendo consultado (cepOrigem/cepDestino)
     * @param cep - O cep que será consultado
     * @param camposInvalidos - Lista onde será adicionado um erro do tipo "Campo", caso o cep seja inválido
     * @return Caso o cep seja válido, retorna o endereço completo referente ao cep.
     * @return Caso o cep seja inválido, um erro será adicionado em "camposInvalidos".
     * @throws Caso o serviço "viacep" não funcione como o esperado, será lançada uma "NegocioException", retornando o status 503
     */
	private ConsultaCepDTO consultarCep(String nomeCampo, String cep, List<Campo> camposInvalidos) {
		ConsultaCepDTO responseEntity = null;
		try {
		responseEntity = restTemplate.getForObject("https://viacep.com.br/ws/"
													+ cep + "/json/", ConsultaCepDTO.class);
		
		} catch(HttpClientErrorException e) {
		camposInvalidos.add(new Campo(nomeCampo, "Cep inválido"));
		
		} catch(Exception e) {
		throw new NegocioException(HttpStatus.SERVICE_UNAVAILABLE, "Serviço indisponível");
		}
		
		return responseEntity;
	}
	
	/**
	 * Este método calcula o preço do frete baseado nos parâmetros recebidos
	 * @param dadosConsulta - Dto que contém os dados necessários para calcular o frete (dados recebidos na requisição da api)
	 * @return Caso os ceps sejam válidos,
	 * retorna um ResponseEntity com o preço do frete calculado, além de informações adicionais presentes em "ConsultaFreteOutputDTO"
	 * @throws Caso pelo menos 1 cep seja inválido, lança uma Exceção do tipo "CamposException"
	 * @throws Caso o serviço "viacep" não funcione como o esperado, será lançada uma "NegocioException", retornando o status 503 
	 */	
	public ResponseEntity<ConsultaFreteOutputDTO> calcularFrete(ConsultaFreteInputDTO dadosConsulta) {
		
		String cepOrigem = dadosConsulta.getCepOrigem();
		String cepDestino = dadosConsulta.getCepDestino();

		List<Campo> camposInvalidos = new LinkedList<>();		
		ConsultaCepDTO enderecoOrigem = consultarCep("cepOrigem", cepOrigem, camposInvalidos);
		ConsultaCepDTO enderecoDestino = consultarCep("cepDestino", cepDestino, camposInvalidos);
		
		if (!camposInvalidos.isEmpty()) {
			throw new CamposException(HttpStatus.BAD_REQUEST, camposInvalidos);
		}
		
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
