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
public class TestExamResultValidation {

	ExamResult examResult;

	@Before
	public void initTest() {
		examResult = new ExamResult();
	}

	@Test
	public void test_ExamResultValidation_CheckPoint_Valid() {
		this.examResult.setPoint1(7);
		assertEquals(true, examResult.checkPoint(examResult.getPoint1()));
	}

	@Test
	public void test_ExamResultValidation_CheckPoint_NotValid_1() {
		this.examResult.setPoint2(11);
		assertEquals(false, examResult.checkPoint(examResult.getPoint2()));
	}

	@Test
	public void test_ExamResultValidation_CheckPoint_NotValid_2() {
		this.examResult.setPoint3(-1);
		assertEquals(false, examResult.checkPoint(examResult.getPoint3()));
	}

	@Test
	public void test_ExamResultValidation_Check_Valid() throws Exception {
		this.examResult.setPoint1(7);
		this.examResult.setPoint2(3);
		this.examResult.setPoint3(9);
		assertEquals("valid", this.examResult.check());
	}

	@Test
	public void test_ExamResultValidation_Check_Not_Valid_1() throws Exception {
		this.examResult.setPoint1(-7);
		this.examResult.setPoint2(3);
		this.examResult.setPoint3(9);
		assertEquals("Exam result is not valid (1 - 10)", this.examResult.check());
	}

	@Test
	public void test_ExamResultValidation_Check_Not_Valid_2() throws Exception {
		this.examResult.setPoint1(-7);
		this.examResult.setPoint2(11);
		this.examResult.setPoint3(9);
		assertEquals("Exam result is not valid (1 - 10)", this.examResult.check());
	}

	@Test
	public void test_ExamResultValidation_Check_Not_Valid_3() throws Exception {
		this.examResult.setPoint1(7);
		this.examResult.setPoint2(3);
		this.examResult.setPoint3(9999);
		assertEquals("Exam result is not valid (1 - 10)", this.examResult.check());
	}

	@Test
	public void test_ExamResultValidation_Check_Throw_Exception() throws Exception {
		this.examResult = null;
		try {
			this.examResult.check();
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Exam result is null");
		}
	}
}
