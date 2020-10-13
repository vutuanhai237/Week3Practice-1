package com.tma.week3Practice_1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.tma.week3Practice_1.model.ExamResultBean;
import com.tma.week3Practice_1.model.StudentBean;
import com.tma.week3Practice_1.validation.StudentValidation;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes = { StudentBean.class,
		ExamResultBean.class }, loader = AnnotationConfigContextLoader.class)
public class TestStudentValidation {
	@Autowired
	private StudentBean student;

	@Before
	public void initTest() {
		student.setName("VuTuanHai");
		student.setAge(21);
		student.setProvince("Gia Lai");
		student.setClasses("12C1");
		student.getExamResult().setPoint1(7);
		student.getExamResult().setPoint2(7);
		student.getExamResult().setPoint3(7);
	}

	@Test
	public void test_StudentValidation_Check_Valid() throws Exception {
		assertEquals("valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_NameNotValid_1() throws Exception {
		student.setName("");
		assertEquals("Name is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_NameNotValid_2() throws Exception {
		student.setName("VuTuanHaiVuTuanHaiVuTuanHaiVuTuanHaiVuTuanHai");
		assertEquals("Name is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_AgeNotValid_1() throws Exception {
		student.setAge(101);
		assertEquals("Age is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_AgeNotValid_2() throws Exception {
		student.setAge(-1);
		assertEquals("Age is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_ProvinceNotValid_1() throws Exception {
		student.setProvince("");
		assertEquals("Province is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_ProvinceNotValid_2() throws Exception {
		student.setProvince(
				"Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai");
		assertEquals("Province is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_ClassesNotValid_1() throws Exception {
		student.setClasses("");
		assertEquals("Class is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_ClassesNotValid_2() throws Exception {
		student.setClasses("12121212121212");
		assertEquals("Class is not valid", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_ExamResultNotValid_1() throws Exception {
		student.getExamResult().setPoint1(-1);
		assertEquals("Exam result is not valid (1 - 10)", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_ExamResultNotValid_2() throws Exception {
		student.getExamResult().setPoint1(11);
		assertEquals("Exam result is not valid (1 - 10)", StudentValidation.check(this.student));
	}

	@Test
	public void test_StudentValidation_Check_Null() {
		this.student = null;
		try {
			StudentValidation.check(this.student);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Student or exam result is null");
		}
	}
}
