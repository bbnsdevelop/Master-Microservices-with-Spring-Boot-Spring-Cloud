package br.com.currencyconversionservice.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;
import br.com.currencyconversionservice.service.feign.ExchangeValue;

public interface CurrencyService {
	
	CurrencyConversionBean convert(String from, String to, BigDecimal qtd);

	CurrencyConversionBean convertFeign(String from, String to, BigDecimal qtd);

	List<ExchangeValue> getAllconvertFeign();

}
