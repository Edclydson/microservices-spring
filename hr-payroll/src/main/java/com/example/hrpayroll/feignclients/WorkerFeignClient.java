package com.example.hrpayroll.feignclients;

import com.example.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8080",path = "/")
public interface WorkerFeignClient{

    @GetMapping("workers/{id}")
    ResponseEntity<Worker> findById(@PathVariable UUID id);
}
