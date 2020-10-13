package com.tma.week3Practice_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tma.week3Practice_1.model.Student;
import com.tma.week3Practice_1.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private Student student;

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/students")
	public @ResponseBody Iterable<Student> readStudents() {
		return studentService.getStudents();
	}

	@PostMapping(path = "/students")
	public @ResponseBody String createStudents(@RequestBody Student student) {
		return studentService.createStudents(student);
	}

	@PutMapping(path = "/students")
	public @ResponseBody String updateStudents(@RequestBody Student student) {
		return studentService.updateStudents(student);
	}

	@DeleteMapping(path = "/students")
	public @ResponseBody String deleteStudents(@RequestParam int student_id) {
		return studentService.deleteStudents(student_id);
	}
}
