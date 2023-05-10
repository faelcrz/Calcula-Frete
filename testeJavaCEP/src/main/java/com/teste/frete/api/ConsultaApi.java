package com.teste.frete.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.teste.frete.model.CepRetornoAPI;

@Component
public class ConsultaApi {
	private RestTemplate template = new RestTemplate();
	
	public CepRetornoAPI retornaFreteConsultaApi(String cep){
		String url = "http://viacep.com.br/ws/"+cep+"/json/";
		System.out.println(url);
		CepRetornoAPI retornoApi = template.getForObject(url, CepRetornoAPI.class);
		
		return retornoApi;
	}
	
}
