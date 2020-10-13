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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StudentBean.class,
		ExamResultBean.class }, loader = AnnotationConfigContextLoader.class)
public class TestStudentBean {
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
	public void test_StudentBean_toString() {
		assertEquals("Name: VuTuanHai, age: 21, class: 12C1, province: Gia Lai, GPA: 7.0, Toán: 7.0, Lý: 7.0, Anh: 7.0",
				student.toString());
	}

}
