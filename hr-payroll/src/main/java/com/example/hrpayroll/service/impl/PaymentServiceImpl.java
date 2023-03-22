package com.example.hrpayroll.service.impl;

import com.example.hrpayroll.entities.Payment;
import com.example.hrpayroll.entities.Worker;
import com.example.hrpayroll.feignclients.WorkerFeignClient;
import com.example.hrpayroll.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final WorkerFeignClient workerFeignClient;

    public PaymentServiceImpl(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }


    @Override
    public Payment getPayment(UUID workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(UUID.randomUUID(),worker.getName(), worker.getDailyIncome(), days);
    }
}
