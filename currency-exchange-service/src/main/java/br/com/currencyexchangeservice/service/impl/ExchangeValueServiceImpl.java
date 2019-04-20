package br.com.currencyexchangeservice.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.currencyexchangeservice.entity.exchange.ExchangeValue;
import br.com.currencyexchangeservice.repositories.ExchangeValueRepository;
import br.com.currencyexchangeservice.service.ExchangeValueService;

@Service
public class ExchangeValueServiceImpl implements ExchangeValueService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;

	@Override
	public ExchangeValue exchangeValue(String from, String to) {		
		ExchangeValue exchangeValue = this.exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(this.environment.getProperty("local.server.port")));
		logger.info("exchange value -> {}", exchangeValue);
		return exchangeValue;
	}

	@Override
	public List<ExchangeValue> allExchangeValue() {
		List<ExchangeValue> list = this.exchangeValueRepository.findAll();
		list.forEach(e ->{
			e.setPort(Integer.parseInt(this.environment.getProperty("local.server.port")));
		});
		return list;
	}
	
	

}
