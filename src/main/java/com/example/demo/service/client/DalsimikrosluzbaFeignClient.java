package com.example.demo.service.client;

import com.example.demo.dto.LoansDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "dalsimikrosluzba", fallback = LoansFallback.class)
public interface DalsimikrosluzbaFeignClient {

    @GetMapping(value = "/api/fetch", consumes = "application/json")
    public String fetchAppointmentDetails(@RequestHeader("walrusbank-correlation-id") String correlationId, @RequestParam String mobileNumber);
}

