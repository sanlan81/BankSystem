package com.spd.entity;

/**
 * Created by Sasha on 03.02.2017.
 */
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "first_name")
     private String firstName;


    @Column(name = "last_name")
     private String lastName;

    @Column(name = "phone_number")
     private String phoneNumber;

    @Column(name = "address")
     private String address;

    @Column(name = "email")
     private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "bank_id", nullable = false)
     private Bank bank;

    public Client(String firstName, String lastName, String phoneNumber, String address, String email, Bank bank) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.bank = bank;
    }
}
