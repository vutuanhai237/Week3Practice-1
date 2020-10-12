package com.tma.week3Practice_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComTurretaSpringAutowiretolistApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {

//		DepartmentBean dept = applicationContext.getBean("departmentBean", DepartmentBean.class);
//
//		Assert.assertTrue(dept.getListOfPersons().size() == 4);
	}

}
