package br.com.currencyconversionservice.service.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.currencyconversionservice.controllers.beans.CurrencyConversionBean;


//@FeignClient(name ="currency-exchange-service", url="localhost:8000")
//@FeignClient(name ="currency-exchange-service")
@FeignClient(name ="netflix-zuul-api-gateway-server")
@RibbonClient(name ="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
