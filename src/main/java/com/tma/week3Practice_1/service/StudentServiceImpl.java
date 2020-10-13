package com.tma.week3Practice_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.repository.StudentRepository;
import com.tma.week3Practice_1.validation.StudentValidation;

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
			if (StudentValidation.check(student) == "valid") {
				studentRepository.delete(student_id);
				studentRepository.save(student);
				return "success";
			} else {
				return StudentValidation.check(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "not success";
	}

	@Override
	public String createStudents(Student student) {
		try {
			if (StudentValidation.check(student) == "valid") {
				studentRepository.save(student);
				return "success";
			} else {
				return StudentValidation.check(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "not success";
	}

	@Override
	public String deleteStudents(int student_id) {
		studentRepository.delete(student_id);
		return "";
	}

}