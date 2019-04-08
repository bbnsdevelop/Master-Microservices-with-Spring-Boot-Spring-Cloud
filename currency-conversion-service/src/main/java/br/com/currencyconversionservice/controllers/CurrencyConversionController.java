package br.com.currencyconversionservice.controllers;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{qtd}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, 
			@PathVariable("qtd") BigDecimal qtd) {
		
		return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, qtd, qtd, 0);
	}
	

}
