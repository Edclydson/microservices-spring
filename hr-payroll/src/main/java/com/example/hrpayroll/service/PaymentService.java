package com.example.hrpayroll.service;

import com.example.hrpayroll.entities.Payment;

import java.util.UUID;

public interface PaymentService{

    Payment getPayment(UUID workerId, int days);
}
