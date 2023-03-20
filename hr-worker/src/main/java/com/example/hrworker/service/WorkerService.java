package com.example.hrworker.service;

import com.example.hrworker.dto.WorkerDTO;
import com.example.hrworker.entities.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService{

    List<Worker> findAll();
    Worker findById(UUID id);
    void save(WorkerDTO workerDto);
}
