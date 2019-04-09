package br.com.currencyconversionservice.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;
import br.com.currencyconversionservice.service.CurrencyService;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{qtd}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, 
			@PathVariable("qtd") BigDecimal qtd) {
		
		return this.currencyService.convert(from, to, qtd);
	}
	

}
