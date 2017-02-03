package com.spd.test.util;

import com.spd.entity.Bank;

public class BankUtil {

    public static Bank createBank() {
        Bank bank = new Bank();
        bank.setName("Gold Bank");

        return bank;
    }

}
