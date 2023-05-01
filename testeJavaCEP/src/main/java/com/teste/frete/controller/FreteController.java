package com.teste.frete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.frete.model.FreteDados;
import com.teste.frete.model.FreteOutput;
import com.teste.frete.service.FreteService;

@RestController
public class FreteController {

	@Autowired
	FreteService service;
	
	@PostMapping("/consultar")
	public ResponseEntity<FreteOutput> consultarCep(@RequestBody FreteDados dados){	
		return service.consultarCep(dados);	
	}
}
