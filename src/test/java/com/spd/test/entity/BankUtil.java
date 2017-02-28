package com.spd.test.entity;

import com.spd.entity.Bank;

/**
 * Created by Sasha on 28.02.2017.
 */
public class BankUtil {
    public static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Gold Bank");

        return bank;
    }
}
