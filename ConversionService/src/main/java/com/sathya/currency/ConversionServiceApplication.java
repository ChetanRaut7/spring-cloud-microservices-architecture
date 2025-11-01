package com.sathya.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients(basePackages = "com.sathya.currency.feign")


@SpringBootApplication
public class ConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionServiceApplication.class, args);
	}

	
//	@Bean
//	@LoadBalanced
//	 public RestTemplate restTemplate () {
//		
//		return new RestTemplate();
//	}
	
	
}
