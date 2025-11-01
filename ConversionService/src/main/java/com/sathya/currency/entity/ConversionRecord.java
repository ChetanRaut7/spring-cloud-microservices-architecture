package com.sathya.currency.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ConversionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromCurrency;
    private String toCurrency;
    private double quantity;
    private double conversionRate;
    private double totalCalculatedAmount;
    private LocalDateTime localDateTime;

    // Getters and Setters
}
