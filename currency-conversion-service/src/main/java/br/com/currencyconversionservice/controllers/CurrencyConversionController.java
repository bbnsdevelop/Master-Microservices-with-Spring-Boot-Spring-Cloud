package br.com.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;
import br.com.currencyconversionservice.service.CurrencyService;
import br.com.currencyconversionservice.service.feign.ExchangeValue;

@RestController
@CrossOrigin(origins = "*")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("currency-converter/from/{from}/to/{to}/quantity/{qtd}")
	public CurrencyConversionBean convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to, 
			@PathVariable("qtd") BigDecimal qtd) {
		
		return this.currencyService.convert(from, to, qtd);
	}
	@GetMapping("currency-converter-feign/from/{from}/to/{to}/quantity/{qtd}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable("from") String from, @PathVariable("to") String to, 
			@PathVariable("qtd") BigDecimal qtd) {
		
		return this.currencyService.convertFeign(from, to, qtd);
	}
	@GetMapping("currency-converter-feign/all-exchange")
	public List<ExchangeValue> getAllExchange() {		
		return this.currencyService.getAllconvertFeign();
	}
	

}
