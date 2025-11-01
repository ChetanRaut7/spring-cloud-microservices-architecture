package com.sathya.currency.dto;


import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class CurrencyResponse implements Serializable{
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double quantity;
    private double conversionRate;
    private double totalCalculatedAmount;
    private LocalDateTime localDateTime;

    // Getters and Setters
}