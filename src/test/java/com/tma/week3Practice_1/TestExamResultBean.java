package com.tma.week3Practice_1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.tma.week3Practice_1.model.ExamResult;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes = ExamResult.class, loader = AnnotationConfigContextLoader.class)
public class TestExamResultBean {

	ExamResult examResult;

	@Before
	public void initTest() {
		examResult = new ExamResult();
		examResult.setPoint1(7);
		examResult.setPoint2(10);
		examResult.setPoint3(7);
	}

	@Test
	public void test_ExamResultBean_getGPA() {
		assertEquals(8.0, this.examResult.getGPA(), 0);
	}

	@Test
	public void test_ExamResultBean_getPoint() {
		assertEquals(7.0, this.examResult.getPoint1(), 0);
	}

	@Test
	public void test_ExamResultBean_toString() {
		assertEquals("Toán: 7.0, Lý: 10.0, Anh: 7.0", this.examResult.toString());
	}
}
