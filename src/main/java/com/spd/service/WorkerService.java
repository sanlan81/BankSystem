package com.spd.service;

import com.spd.entity.Worker;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sasha on 05.02.2017.
 */
public interface WorkerService {

        Worker addWorker(Worker worker);

        void delete(long id);

        Worker editWorker(Worker worker);

        List<Worker> getAll();

        void getEmployeeEfficiency();

        Set<String> getExtensionList(String folder);

        Map<String,Integer> getExtensionCount(String folder);

        //Worker get(int id);

}
