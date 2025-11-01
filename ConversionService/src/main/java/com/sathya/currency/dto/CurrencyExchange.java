package com.sathya.currency.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class CurrencyExchange {

    @Id
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private Double conversionRate;
}