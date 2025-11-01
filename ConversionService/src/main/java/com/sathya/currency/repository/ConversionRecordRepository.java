package com.sathya.currency.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.currency.entity.ConversionRecord;

public interface ConversionRecordRepository extends JpaRepository<ConversionRecord, Long> {
}

