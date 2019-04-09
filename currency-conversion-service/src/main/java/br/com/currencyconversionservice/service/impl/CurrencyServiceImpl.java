package br.com.currencyconversionservice.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;
import br.com.currencyconversionservice.service.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService{
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	@Override
	public CurrencyConversionBean convert(String from, String to, BigDecimal qtd) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		log.info("calling currency-exchange-service method retriveExchangeValue");
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000//currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean respose = responseEntity.getBody();
		
		return new CurrencyConversionBean(respose.getId(), from, to, respose.getConversionMultiple(), qtd, qtd.multiply(respose.getConversionMultiple()), respose.getPort());
	}

}
