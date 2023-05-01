package com.teste.frete.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teste.frete.model.CepRetornoAPI;
import com.teste.frete.model.FreteDados;
import com.teste.frete.model.FreteData;
import com.teste.frete.model.FreteOutput;
import com.teste.frete.repository.FreteRepository;

@Service
public class FreteService {
	@Autowired
	FreteRepository repository;
	@Autowired
	ConsultaApi consulta;
	
	public ResponseEntity<FreteOutput> consultarCep(FreteDados freteDados){
		CepRetornoAPI cepOrigem =  consulta.retornaFreteConsultaApi(freteDados.getCepOrigem());
		CepRetornoAPI cepDestino = consulta.retornaFreteConsultaApi(freteDados.getCepDestino());
		double descontoFrete = determinarDescontoFrete(cepOrigem, cepDestino);
		int diasFrete = determinarDiasFrete(cepOrigem, cepDestino);
		double valorTotalFrete = freteDados.getPeso() * descontoFrete;
		FreteData freteDb = new FreteData(freteDados.getPeso(), cepOrigem.getCep(), cepDestino.getCep(), freteDados.getNomeDestinatario(),
				 valorTotalFrete, getDataPrevistaEntrega(getDataConsulta(), diasFrete), getDataConsulta());	
			
		repository.save(freteDb);
		return ResponseEntity.ok(new FreteOutput(valorTotalFrete, getDataPrevistaEntrega(getDataConsulta(), diasFrete) , cepOrigem.getCep()));
	}
	
	public int determinarDiasFrete(CepRetornoAPI cepOrigem, CepRetornoAPI cepDestino) {
	    if (cepOrigem.getUf().equals(cepDestino.getUf())) {
	        return 1;
	    } else if (cepOrigem.getDdd().equals(cepDestino.getDdd())) {
	        return 3;
	    } else {
	        return 10;
	    }
	}
	
	public Double determinarDescontoFrete(CepRetornoAPI cepOrigem, CepRetornoAPI cepDestino) {
		if(cepOrigem.getUf().equals(cepDestino.getUf())) {
			return 0.5;
		} else if(cepOrigem.getDdd().equals(cepDestino.getDdd())) {
			return 0.25;
	    } else {
	        return 1.0;
	    }
	}
	
    public Date getDataConsulta() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }
    
    public Date getDataPrevistaEntrega(Date data, int dias) {
    	Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, dias); 
         
    	return calendar.getTime();
    }
}
