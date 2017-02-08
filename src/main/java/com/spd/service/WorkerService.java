package com.spd.service;

import com.spd.entity.Worker;

import java.util.List;

/**
 * Created by Sasha on 05.02.2017.
 */
public interface WorkerService {

        Worker addWorker(Worker worker);
        void delete(long id);
        Worker editWorker(Worker worker);
        List<Worker> getAll();
        //Worker get(int id);

}
