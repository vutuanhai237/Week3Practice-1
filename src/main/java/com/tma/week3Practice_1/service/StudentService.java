package com.tma.week3Practice_1.service;

import org.springframework.stereotype.Service;

import com.tma.week3Practice_1.model.Student;

@Service
public interface StudentService {
	public Iterable<Student> getStudents();

	public String updateStudents(int student_id, Student student);

	public String createStudents(Student student);

	public String deleteStudents(int student_id);
}
