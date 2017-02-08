
package com.spd.repository;


/**
 * Created by Sasha on 03.02.2017.
 */

import com.spd.entity.Worker;
import com.spd.entity.enums.WorkerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    @Query(value = "SELECT * FROM Worker  WHERE status = ?1",nativeQuery = true)
    List<Worker> findAllManagers(WorkerStatus status);

    List<Worker> findByFirstNameNotLike(String prefix);
}

