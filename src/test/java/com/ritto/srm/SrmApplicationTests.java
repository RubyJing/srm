package com.ritto.srm;

import com.ritto.srm.Entity.CpuBean;
import com.ritto.srm.service.jpa.cpuRepository;
import com.ritto.srm.service.jpa2.cpuRepository2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SrmApplicationTests {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private cpuRepository cpuRepository;

	@Autowired
	private cpuRepository2 cpuRepository2;


	@Test
	public void contextLoads() {
		CpuBean cpu = cpuRepository.findById(1).get();
		Assert.assertNotNull(cpu);
		List tablelist = entityManager.createNativeQuery("select table_name from information_schema.tables where table_schema='Hotel_manage'").getResultList();
		List tablelist2 = cpuRepository2.findalltab();
	}

}
