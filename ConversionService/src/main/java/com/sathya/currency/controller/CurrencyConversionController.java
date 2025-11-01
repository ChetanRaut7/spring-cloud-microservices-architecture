package com.sathya.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.currency.dto.CurrencyRequest;
import com.sathya.currency.dto.CurrencyResponse;
import com.sathya.currency.service.CurrencyConversionService;

@RestController
@RequestMapping("/api/v1/conversion")
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService service;

//    @PostMapping("/finalamount")
//    public CurrencyResponse getFinalAmount(@RequestBody CurrencyRequest request) {
//        return service.convertCurrency(request);
//    }
    
    @PostMapping
    public CurrencyResponse convertCurrency(@RequestBody CurrencyRequest currencyRequest) {
        return service.convertCurrency(currencyRequest);
    }
}


