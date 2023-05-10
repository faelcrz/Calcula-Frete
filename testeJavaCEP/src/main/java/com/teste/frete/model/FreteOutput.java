package com.teste.frete.model;

import java.util.Date;

public class FreteOutput {
	private double vlTotalFrete;
	private Date dataPrevistaEntrega;
	private String cepOrigem;
	
	public FreteOutput(double vlTotalFrete, Date dataPrevistaEntrega, String cepOrigem) {
		super();
		this.vlTotalFrete = vlTotalFrete;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.cepOrigem = cepOrigem;
	}
	
	public double getVlTotalFrete() {
		return vlTotalFrete;
	}
	public void setVlTotalFrete(float vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}
	public Date getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}
	public void setDataPrevistaEntrega(Date dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}
	public String getCepOrigem() {
		return cepOrigem;
	}
	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}
	

}
