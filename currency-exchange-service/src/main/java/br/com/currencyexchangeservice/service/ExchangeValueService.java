package br.com.currencyexchangeservice.service;

import br.com.currencyexchangeservice.entity.exchange.ExchangeValue;

public interface ExchangeValueService {

	ExchangeValue exchangeValue(String from, String to);
}
