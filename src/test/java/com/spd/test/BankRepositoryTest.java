package com.spd.test;

import com.spd.entity.Bank;
import com.spd.repository.BankRepository;
import com.spd.test.config.TestDataBaseConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BankRepositoryTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private BankRepository bankRepository;

    private Bank bank1, bank2, bank3;
    private long id;

    @Before
    public void setUp() throws Exception {
        bank1 = new Bank("Bank Flora");
        bank2 = new Bank("Bank Money");
        bank1.setId(1);
        bank2.setId(2);
        this.bankRepository.save(bank1);
        this.bankRepository.save(bank2);

        em = emf.createEntityManager();

    }

    @Test
    public void isEntitiesNullOrNotNull() {
        id = bank1.getId();
        assertThat(id, is(notNullValue()));
        assertThat(bank1.getId(), is(notNullValue()));
        assertThat(bank2.getId(), is(notNullValue()));
        Assert.assertNull(bank3);
    }

    @Test
    public void testDeleteBank() throws Exception {

        bankRepository.delete(bank1);
        assertThat(bankRepository.exists(id), is(false));
        assertThat(bankRepository.findOne(id), is(nullValue()));
    }

    @Test
    public void testGetAllBanks() throws Exception {

        List<Bank> allBank = bankRepository.findAll();
        assertThat(allBank.size(), is(2));
    }

    @Test
    public void testAddNewBank() throws Exception {
        id = bank1.getId();
        assertThat(id, is(notNullValue()));
    }

    @Test
    public void isEmpty() throws Exception {
        List<Bank> byName = bankRepository.findAll();
        assertThat(byName.isEmpty(), is(false));
    }

    @Test
    public void testShouldBankEqualName() throws Exception{

        Bank bankName = bankRepository.findByName("Bank Flora");
        assertThat(bankName, is(notNullValue()));
        assertThat(bankName.getName(), is(bank1.getName()));
    }

}
