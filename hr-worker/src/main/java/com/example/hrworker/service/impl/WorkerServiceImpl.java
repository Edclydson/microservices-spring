package com.example.hrworker.service.impl;

import com.example.hrworker.dto.WorkerDTO;
import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;
import com.example.hrworker.service.WorkerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkerServiceImpl implements WorkerService{

    private final WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> findAll() {
        List<Worker> list = workerRepository.findAll();
        return list;
    }

    @Override
    public Worker findById(UUID id) {
        Worker worker = workerRepository.findById(id).get();
        return worker;
    }

    @Override
    public void save(WorkerDTO workerDto) {
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setDailyIncome(workerDto.getDailyIncome());
        workerRepository.save(worker);
    }
}
