package com.spd.repository;

/**
 * Created by Sasha on 03.02.2017.
 */
import com.spd.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
