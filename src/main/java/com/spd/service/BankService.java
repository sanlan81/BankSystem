package com.spd.service;

/**
 * Created by Sasha on 03.02.2017.
 */
import com.spd.entity.Bank;

import java.util.List;

public interface BankService {

    Bank addBank(Bank bank);

    void delete(long id);

    Bank editBank(Bank bank);

    List<Bank> getAll();


    Bank getByName(String name);

    void refreshAllBanks();

}
