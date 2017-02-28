package com.spd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sasha on 28.02.2017.
 */
@Data
@NoArgsConstructor
public class Atm {
    private long id;
    private String name ;
    private String address;
    private long serialNumber ;
    private long pinCode;
}
