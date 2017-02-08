package com.spd.service.impl;

import com.spd.entity.Worker;
import com.spd.repository.WorkerRepository;
import com.spd.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sasha on 06.02.2017.
 */
@Service
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    WorkerRepository workerRepository;

    @Override
    public Worker addWorker(Worker worker) {
        return workerRepository.saveAndFlush(worker);
    }

    @Override
    public void delete(long id) {
        workerRepository.delete(id);
    }

    @Override
    public Worker editWorker(Worker worker) {
        return workerRepository.saveAndFlush(worker);
    }

    @Override
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }


}
