package br.com.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.currencyexchangeservice.entity.exchange.ExchangeValue;
import br.com.currencyexchangeservice.service.ExchangeValueService;


@RestController
public class CurrencyExchangeController {
	
	
	
	@Autowired
	private ExchangeValueService exchangeValueService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to ) {		
		
		return this.exchangeValueService.exchangeValue(from, to);
	}
}
