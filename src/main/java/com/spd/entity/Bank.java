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
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name")
    @NonNull private String name;


}