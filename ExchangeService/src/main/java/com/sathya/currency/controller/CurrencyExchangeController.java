package com.sathya.currency.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.currency.entity.CurrencyExchange;
import com.sathya.currency.repository.CurrencyExchangeRepository;





@RequestMapping("/api/v1/exchange")
@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getExchangeRate(@PathVariable String from, @PathVariable String to) {
        return repository.findByFromCurrencyAndToCurrency(from, to)
                .orElseThrow(() -> new RuntimeException("Exchange rate not found for " + from + " to " + to));
    }
}


