package com.sathya.currency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.currency.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
