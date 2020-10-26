package com.tma.week3Practice_1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.repository.StudentRepository;
import com.tma.week3Practice_1.service.StudentService;
import com.tma.week3Practice_1.utils.Constant;

@Service
@Primary
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public String updateStudents(int student_id, Student student) {
		try {
			if (student.check() == "valid") {
				studentRepository.delete(student_id);
				studentRepository.save(student);
				return Constant.SUCCESS;
			} else {
				return student.check();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constant.NOT_SUCCESS;
	}

	@Override
	public String createStudents(Student student) {
		try {
			if (student.check() == "valid") {
				studentRepository.save(student);
				return Constant.SUCCESS;
			} else {
				return student.check();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.NOT_SUCCESS;
		}
	}

	@Override
	public String deleteStudents(int student_id) {
		try {
			studentRepository.delete(student_id);
			return Constant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.NOT_SUCCESS;
		}

	}

}