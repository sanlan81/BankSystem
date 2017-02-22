package com.spd.entity;

/**
 * Created by Sasha on 03.02.2017.
 */
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
@RequiredArgsConstructor()
@NoArgsConstructor
@Data
@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "currency")
    @NonNull private double currency;

    @Column(name = "amount")
    @NonNull private double amount;

    @Column(name = "amount_of_credit")
    @NonNull private double amountOfCredit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "client_id", nullable = false)
    @NonNull private Client client;

}
