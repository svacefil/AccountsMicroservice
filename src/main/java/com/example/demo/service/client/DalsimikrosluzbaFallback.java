package com.example.demo.service.client;

import org.springframework.stereotype.Component;

@Component
public class DalsimikrosluzbaFallback implements DalsimikrosluzbaFeignClient{
    @Override
    public String fetchAppointmentDetails(String correlationId, String mobileNumber) {
        return "";
    }
}
