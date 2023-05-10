package com.teste.frete.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FreteData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double peso;
	private double vlTotalFrete;
	private String cepOrigem;
	private String cepDestino;
	private String nomeDestinatario;
	private Date dataPrevistaEntrega;
	private Date dataPrevistaConsulta;
	
	public FreteData(double peso, String cepOrigem, String cepDestino, String nomeDestinatario, double vlTotalFrete,
			Date dataPrevistaEntrega, Date dataPrevistaConsulta) {

		this.peso = peso;
		this.cepOrigem = cepOrigem;
		this.cepDestino = cepDestino;
		this.nomeDestinatario = nomeDestinatario;
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataPrevistaConsulta = dataPrevistaConsulta;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public Date getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public Date getDataPrevistaConsulta() {
		return dataPrevistaConsulta;
	}

	public void setDataPrevistaConsulta(Date dataPrevistaConsulta) {
		this.dataPrevistaConsulta = dataPrevistaConsulta;
	}

}
