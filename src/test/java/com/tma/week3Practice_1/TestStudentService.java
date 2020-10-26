package com.tma.week3Practice_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.tma.week3Practice_1.model.ExamResult;
import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.repository.StudentRepository;
import com.tma.week3Practice_1.service.impl.StudentServiceImpl;
import com.tma.week3Practice_1.utils.Constant;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = { Student.class, ExamResult.class }, loader = AnnotationConfigContextLoader.class)
public class TestStudentService {
	private Student student;
	@Mock
	private StudentRepository studentRepository;
	@InjectMocks
	private StudentServiceImpl studentService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		student = new Student();
		student.setName("Hai");
		student.setAge(21);
		student.setProvince("Gia Lai");
		student.setClasses("12C1");
		student.setExamResult(new ExamResult());
		student.getExamResult().setPoint1(7);
		student.getExamResult().setPoint2(7);
		student.getExamResult().setPoint3(7);
	}

	@Test
	public void test_StudentService_getStudent_Valid1() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(student);
		students.add(student);
		Mockito.when(studentService.getStudents()).thenReturn(students);
		assertEquals(((ArrayList<Student>) studentService.getStudents()).size(), 2);
	}

	@Test
	public void test_StudentService_getStudent_Valid2() {
		ArrayList<Student> students = new ArrayList<Student>();
		Mockito.when(studentService.getStudents()).thenReturn(students);
		assertEquals(((ArrayList<Student>) studentService.getStudents()).size(), 0);
	}

	@Test
	public void test_StudentService_createStudent_Valid() {
		assertEquals(Constant.SUCCESS, studentService.createStudents(student));
	}

	@Test
	public void test_StudentService_createStudent_NotValid() {
		student.setAge(101);
		assertEquals("Age is not valid", studentService.createStudents(student));
	}

}
