package com.tma.week3Practice_1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.tma.week3Practice_1.model.ExamResult;
import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.utils.Constant;

@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes = { Student.class, ExamResult.class }, loader = AnnotationConfigContextLoader.class)
public class TestStudentValidation {
	private Student student = new Student();

	@Before
	public void initTest() {
		student.setName("VuTuanHai");
		student.setAge(21);
		student.setProvince("Gia Lai");
		student.setClasses("12C1");
		student.setExamResult(new ExamResult());
		student.getExamResult().setPoint1(7);
		student.getExamResult().setPoint2(7);
		student.getExamResult().setPoint3(7);
	}

	@Test
	public void test_StudentValidation_Check_Valid() throws Exception {
		assertEquals(Constant.VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_NameNotValid_1() throws Exception {
		student.setName("");
		assertEquals(Constant.STUDENT_NAME_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_NameNotValid_2() throws Exception {
		student.setName("VuTuanHaiVuTuanHaiVuTuanHaiVuTuanHaiVuTuanHai");
		assertEquals(Constant.STUDENT_NAME_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_AgeNotValid_1() throws Exception {
		student.setAge(101);
		assertEquals(Constant.STUDENT_AGE_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_AgeNotValid_2() throws Exception {
		student.setAge(-1);
		assertEquals(Constant.STUDENT_AGE_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_ProvinceNotValid_1() throws Exception {
		student.setProvince("");
		assertEquals(Constant.STUDENT_PROVINCE_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_ProvinceNotValid_2() throws Exception {
		student.setProvince(
				"Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai Gia Lai");
		assertEquals(Constant.STUDENT_PROVINCE_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_ClassesNotValid_1() throws Exception {
		student.setClasses("");
		assertEquals(Constant.STUDENT_CLASS_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_ClassesNotValid_2() throws Exception {
		student.setClasses("12121212121212");
		assertEquals(Constant.STUDENT_CLASS_IS_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_ExamResultNotValid_1() throws Exception {
		student.getExamResult().setPoint1(-1);
		assertEquals(Constant.EXAM_RESULT_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_ExamResultNotValid_2() throws Exception {
		student.getExamResult().setPoint1(11);
		assertEquals(Constant.EXAM_RESULT_NOT_VALID, this.student.check());
	}

	@Test
	public void test_StudentValidation_Check_Null() {
		this.student = null;
		try {
			this.student.check();
		} catch (Exception e) {
			assertEquals(e.getMessage(), null);
		}
	}
}
