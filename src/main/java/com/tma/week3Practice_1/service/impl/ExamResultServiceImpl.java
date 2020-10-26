package com.tma.week3Practice_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.repository.StudentRepository;
import com.tma.week3Practice_1.service.StudentService;

@Service
public class ExamResultServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Iterable<Student> getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createStudents(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudents(int student_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudents(int student_id, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}