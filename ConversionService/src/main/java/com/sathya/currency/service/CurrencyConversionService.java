package com.sathya.currency.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sathya.currency.dto.CurrencyExchange;
import com.sathya.currency.dto.CurrencyRequest;
import com.sathya.currency.dto.CurrencyResponse;
import com.sathya.currency.entity.ConversionRecord;
import com.sathya.currency.feign.FeignClientCode;
//import com.sathya.currency.feign.FeignClientCode;
import com.sathya.currency.repository.ConversionRecordRepository;

@Service
public class CurrencyConversionService {
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	private FeignClientCode feignClient;

    @Autowired
    private ConversionRecordRepository repository;

    
    @Cacheable(value = "exchangeRates", key = "#request.fromCurrency + '_' + #request.toCurrency")
    public CurrencyResponse convertCurrency(CurrencyRequest request) {
    	
    	// 👇 Confirmation log — appears only on first call
        System.out.println(">>> Fetching rate from ExchangeService (not from cache)");
    	
        CurrencyExchange exchangeObject = feignClient.retrieveExchangeValue(
                request.getFromCurrency(), request.getToCurrency());

            double conversionRate = exchangeObject.getConversionRate();
            double totalAmount = request.getQuantity() * conversionRate;

    	
    	
     //   double conversionRate = 86.5; // Static value for now
   
            
            
//        String url = "http://ExchangeService/api/v1/exchange/from/" +
//                request.getFromCurrency() +
//                "/to/" + request.getToCurrency();
        
       // RestTemplate restTemplate = new RestTemplate();
//		   CurrencyExchange exchangeObject = restTemplate
//		           .getForEntity(url, CurrencyExchange.class)
//		           .getBody();
//		
//		   double conversionRate = exchangeObject.getConversionRate();
//		   double totalAmount = request.getQuantity() * conversionRate;
//   
            
            
//    	WebClient webClient = WebClient.create("http://localhost:8005");
//    	 CurrencyExchange exchangeObject = webClient.get()
//    	            .uri("/api/v1/exchange/from/{from}/to/{to}",
//    	                 request.getFromCurrency(), request.getToCurrency())
//    	            .retrieve()
//    	            .bodyToMono(CurrencyExchange.class)
//    	            .block();
//
//    	    double conversionRate = exchangeObject.getConversionRate();
//    	    double totalAmount = request.getQuantity() * conversionRate;


        ConversionRecord record = new ConversionRecord();
        record.setFromCurrency(request.getFromCurrency());
        record.setToCurrency(request.getToCurrency());
        record.setQuantity(request.getQuantity());
        record.setConversionRate(conversionRate);
        record.setTotalCalculatedAmount(totalAmount);
        record.setLocalDateTime(LocalDateTime.now());

        ConversionRecord saved = repository.save(record);

        CurrencyResponse response = new CurrencyResponse();
        response.setId(saved.getId());
        response.setFromCurrency(saved.getFromCurrency());
        response.setToCurrency(saved.getToCurrency());
        response.setQuantity(saved.getQuantity());
        response.setConversionRate(saved.getConversionRate());
        response.setTotalCalculatedAmount(saved.getTotalCalculatedAmount());
        response.setLocalDateTime(saved.getLocalDateTime());

        return response;
    }
}
