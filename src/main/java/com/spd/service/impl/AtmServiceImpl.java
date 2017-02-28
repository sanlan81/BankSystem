package com.spd.service.impl;

import com.spd.service.AtmService;
import org.springframework.stereotype.Service;

/**
 * Created by Sasha on 28.02.2017.
 */
@Service("atmService")
public class AtmServiceImpl implements AtmService{


    @Override
    public long enterPinCode(long pin) {

        for (int i = 3; i >= pin; i--) {
            if (i > 0) {
                System.out.println("Effort number " + i);
            } else {
                System.out.println("You don't have Efforts any more ");
            }
        }
        return pin;
    }
}
