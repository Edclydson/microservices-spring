package com.example.hrworker.controller;

import com.example.hrworker.dto.WorkerDTO;
import com.example.hrworker.entities.Worker;
import com.example.hrworker.service.impl.WorkerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class WorkerController{

    private final WorkerServiceImpl workerService;

    public WorkerController(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }


    @GetMapping("/workers")
    public ResponseEntity<List<Worker>> allWorkers(){
        return ResponseEntity.ok(workerService.findAll());
    }

    @GetMapping("/workers/{id}")
    public ResponseEntity<Worker> findById(@PathVariable UUID id){
        return ResponseEntity.ok(workerService.findById(id));
    }

    @PostMapping("/workers")
    public ResponseEntity save(@RequestBody WorkerDTO workerDto, UriComponentsBuilder uriComponentsBuilder){
        var uri = uriComponentsBuilder.path("/workers/{id}").build(workerDto);
        workerService.save(workerDto);
        return ResponseEntity.created(uri).build();
    }
}
