package com.teste.frete.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.teste.frete.api.ConsultaApi;
import com.teste.frete.entity.FreteData;
import com.teste.frete.model.CepRetornoAPI;
import com.teste.frete.model.FreteDados;
import com.teste.frete.model.FreteOutput;
import com.teste.frete.repository.FreteRepository;
import com.teste.frete.util.DateUtil;

@Service
public class FreteService {
	@Autowired
	FreteRepository repository;
	@Autowired
	ConsultaApi consulta;
	@Autowired
	DateUtil dateUtil;

	public ResponseEntity<FreteOutput> consultarCep(FreteDados freteDados) {
		CepRetornoAPI cepOrigem = consulta.retornaFreteConsultaApi(freteDados.getCepOrigem());
		CepRetornoAPI cepDestino = consulta.retornaFreteConsultaApi(freteDados.getCepDestino());
		double descontoFrete = determinarDescontoFrete(cepOrigem, cepDestino);
		int diasFrete = determinarDiasFrete(cepOrigem, cepDestino);
		double valorTotalFrete = freteDados.getPeso() * descontoFrete;
		FreteData freteDb = new FreteData(freteDados.getPeso(), cepOrigem.getCep(), cepDestino.getCep(),
				freteDados.getNomeDestinatario(), valorTotalFrete,
				dateUtil.getDataPrevistaEntrega(dateUtil.getDataConsulta(), diasFrete), dateUtil.getDataConsulta());

		repository.save(freteDb);

		return ResponseEntity.ok(new FreteOutput(valorTotalFrete,
				dateUtil.getDataPrevistaEntrega(dateUtil.getDataConsulta(), diasFrete), cepOrigem.getCep()));
	}

	private int determinarDiasFrete(CepRetornoAPI cepOrigem, CepRetornoAPI cepDestino) {
		return cepOrigem.getUf().equals(cepDestino.getUf()) ? 1
				: cepOrigem.getDdd().equals(cepDestino.getDdd()) ? 3 : 10;
	}

	private Double determinarDescontoFrete(CepRetornoAPI cepOrigem, CepRetornoAPI cepDestino) {
		return cepOrigem.getUf().equals(cepDestino.getUf()) ? 0.5
				: cepOrigem.getDdd().equals(cepDestino.getDdd()) ? 0.25 : 1.0;
	}

}
