package com.spd.service.impl;

import com.spd.entity.Bank;
import com.spd.entity.Worker;
import com.spd.repository.WorkerRepository;
import com.spd.service.WorkerService;
import com.spd.utils.CustomFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

import static com.spd.entity.enums.WorkerStatus.MANAGER;

/**
 * Created by Sasha on 06.02.2017.
 */
@Service("workerService")
public class WorkerServiceImpl implements WorkerService {

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

    @Override
    public void getEmployeeEfficiency() {

        //edit new worker
          editWorker(new Worker("Gena", "Federrer", MANAGER, "33-22-90", new Bank("USA")));
    }

    //to know all information about Worker from CP
    public Set<String> getExtensionList(String folder){

        File dir = new File(folder);

        Set<String> extList = new TreeSet<>();

        for (String fileName: dir.list()) {

            File file = new File(dir.getAbsolutePath() + "\\" + fileName);

            int i = fileName.lastIndexOf(".");

            if(file.isFile() && i != -1){
                extList.add(fileName.substring(i + 1,fileName.length()).toLowerCase());
            }
        }
        return extList;
    }

    public Map<String,Integer> getExtensionCount(String folder){
        File dir = new File(folder);

        Map<String,Integer> map = new HashMap<>();

        for (String ext: getExtensionList(folder)) {

            FilenameFilter filter = new CustomFileFilter(ext);

            map.put(ext,dir.listFiles(filter).length);
        }
        return map;
    }
}
