package com.spd.entity;

/**
 * Created by Sasha on 03.02.2017.
 */
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@RequiredArgsConstructor()
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
    @NonNull private String firstName;

    @Column(name = "last_name")
    @NonNull private String lastName;

    @Column(name = "phone_number")
    @NonNull private String phoneNumber;

    @Column(name = "address")
    @NonNull private String address;

    @Column(name = "email")
    @NonNull private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "bank_id", nullable = false)
    @NonNull private Bank bank;
}
