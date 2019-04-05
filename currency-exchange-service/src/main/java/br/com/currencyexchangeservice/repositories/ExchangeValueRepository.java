package br.com.currencyexchangeservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.currencyexchangeservice.entity.exchange.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);
}
