package com.tma.week3Practice_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.repository.StudentRepository;

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
	public String updateStudents(Student student) {
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

}