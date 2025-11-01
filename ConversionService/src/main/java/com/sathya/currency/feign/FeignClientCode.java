package com.sathya.currency.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sathya.currency.dto.CurrencyExchange;

@FeignClient(name = "ExchangeService", configuration = FeignConfig.class)
public interface FeignClientCode {

   @GetMapping("/api/v1/exchange/from/{from}/to/{to}")
   CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}


//url = "http://localhost:8005"