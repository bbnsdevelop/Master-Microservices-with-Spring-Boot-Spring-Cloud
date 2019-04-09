package br.com.currencyconversionservice.service;

import java.math.BigDecimal;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;

public interface CurrencyService {
	
	CurrencyConversionBean convert(String from, String to, BigDecimal qtd);

}
