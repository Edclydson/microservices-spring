package com.example.hrpayroll.controller;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.service.impl.PaymentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController{

    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/worker/{workerId}/days/{days}")
    public Payment getPayment(@PathVariable UUID workerId, @PathVariable int days){
        return paymentService.getPayment(workerId, days);
    }
}
