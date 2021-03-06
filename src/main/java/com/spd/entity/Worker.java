package com.spd.entity;

/**
 * Created by Sasha on 03.02.2017.
 */
import com.spd.entity.enums.WorkerStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    @Autowired
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private WorkerStatus status;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;


    public Worker(String firstName, String lastName, WorkerStatus status, String phoneNumber, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.bank = bank;
    }
}
