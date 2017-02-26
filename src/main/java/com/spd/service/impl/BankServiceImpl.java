package com.spd.service.impl;

/**
 * Created by Sasha on 03.02.2017.
 */
import com.spd.entity.Bank;
import com.spd.repository.BankRepository;
import com.spd.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bankService")
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank addBank(Bank bank) {

        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public void delete(long id) {
        bankRepository.delete(id);
    }

    @Override
    public Bank editBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }



    @Override
    @Cacheable(value = "banks")
    public Bank getByName(String name) {
        slowLookupOperation();
        return new Bank(name);
    }

    @CacheEvict(value = "banks", allEntries = true)
    public void refreshAllBanks() {
        //This method will remove all 'banks' from cache, say as a result of flush API.
    }

    public void slowLookupOperation(){
        try {
            long time = 5000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
