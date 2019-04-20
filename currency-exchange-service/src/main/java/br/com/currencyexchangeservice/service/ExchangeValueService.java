package br.com.currencyexchangeservice.service;

import java.util.List;

import br.com.currencyexchangeservice.entity.exchange.ExchangeValue;

public interface ExchangeValueService {

	ExchangeValue exchangeValue(String from, String to);

	List<ExchangeValue> allExchangeValue();
}
