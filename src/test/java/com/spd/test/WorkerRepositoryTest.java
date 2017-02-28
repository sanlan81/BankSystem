package com.spd.test;

import com.spd.entity.Bank;
import com.spd.entity.Worker;
import com.spd.repository.WorkerRepository;
import com.spd.test.config.TestDataBaseConfig;
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

import static com.spd.entity.enums.WorkerStatus.MANAGER;
import static com.spd.entity.enums.WorkerStatus.OFFICERWORKER;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestDataBaseConfig.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class WorkerRepositoryTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private WorkerRepository workerRepository;

    private Worker worker1, worker2, worker3;
    private Long id;
    private Bank bank1, bank2, bank3;


    @Before
    public void setUp() throws Exception {
        bank1 = new Bank("Bank Flora");
        worker1 = new Worker("Gena", "Pherdishenko", MANAGER, "33-22-90", bank1);
        worker1.setId(1);

        bank2 = new Bank("Bank Money");
        worker2 = new Worker("Slava", "Pherdishenko", OFFICERWORKER, "33-22-91", bank2);
        worker2.setId(2);

        bank3 = new Bank("Bank Money");
        worker3 = new Worker("Hannah", "Smith", MANAGER, "33-00-90", bank3);
        worker3.setId(3);

        this.workerRepository.save(worker1);
        this.workerRepository.save(worker2);
        this.workerRepository.save(worker3);
        workerRepository.flush();
        em = emf.createEntityManager();
        id = worker1.getId();
        assertThat(id, is(notNullValue()));
        assertThat(worker2.getId(), is(notNullValue()));

    }


    @Test
    public void testShouldBeEqualSize() throws Exception {

        final List<Worker> allWorkers = workerRepository.findAll();
        assertThat(allWorkers.size(), is(3));
        assertThat(allWorkers.get(0).getFirstName(), is(worker1.getFirstName()));
    }

    @Test
    public void testSaveWorker() throws Exception {

        id = worker1.getId();
        assertThat(id, is(notNullValue()));
    }

    @Test
    public void testDeleteWorker() throws Exception {
        workerRepository.delete(worker1);
        assertThat(workerRepository.exists(id), is(false));
        assertThat(workerRepository.findOne(id), is(nullValue()));
    }

    @Test
    public void testDeleteWorkerById() throws Exception {

        List<Worker> list = workerRepository.findAll();
        workerRepository.delete(list.get(0).getId());
        assertThat(workerRepository.exists(id), is(false));
        assertThat(workerRepository.findOne(id), is(nullValue()));
    }

    @Test
    public void testCountWorkers() throws Exception {
        assertThat(this.workerRepository.findAll().size(), is(3));

    }

    @Test
    public void testUpdate() throws Exception {

        Worker foundWorker = workerRepository.findOne(worker1.getId());
        foundWorker.setFirstName("My new name Sregey");
        workerRepository.save(foundWorker);
        Worker updatedWorker = workerRepository.findOne(worker1.getId());
        assertThat(updatedWorker.getFirstName(), is(foundWorker.getFirstName()));
    }

    @Test
    public void testShouldNotReturnCorrectly() throws Exception {
        long count = workerRepository.count();

        Worker worker4 = new Worker();
        worker4.setFirstName("Bob");
        worker4.setLastName("Stringer");
        worker4.setBank(bank2);
        worker4.setPhoneNumber("22-44-90");
        worker4.setStatus(OFFICERWORKER);
        worker4.setId(4);
        workerRepository.save(worker4);

        assertThat(workerRepository.count() == count + 12, is(false));
    }

    @Test
    public void testFindStatus() throws Exception {

        List<Worker> manager = workerRepository.findAll();
        assertThat(MANAGER, is(manager.get(0).getStatus()));

    }

    @Test
    public void testShouldReturnResultNotAsExecute() throws Exception {
        List<Worker> result = workerRepository.findByFirstNameNotLike("goto%");
        assertThat(result.size(), is(3));
    }
}
