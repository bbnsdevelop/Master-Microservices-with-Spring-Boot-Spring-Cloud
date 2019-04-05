package br.com.currencyexchangeservice.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.currencyexchangeservice.entity.exchange.ExchangeValue;
import br.com.currencyexchangeservice.repositories.ExchangeValueRepository;
import br.com.currencyexchangeservice.service.ExchangeValueService;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@Override
	public ExchangeValue exchangeValue(String from, String to) {		
		ExchangeValue exchangeValue = this.exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(this.environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	

}
