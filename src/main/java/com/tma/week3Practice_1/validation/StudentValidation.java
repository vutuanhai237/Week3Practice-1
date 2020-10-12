package com.tma.week3Practice_1.validation;

import com.tma.week3Practice_1.model.StudentBean;

public class StudentValidation {
	public static String check(StudentBean student) {
		String message = "valid";
		if (student.getName().length() > 30) {
			return "Name was tool long!";
		} else if (student.getAge() < 0 || student.getAge() > 100) {
			return "Age is not valid";
		} else if (student.getClasses().length() < 1 || student.getClasses().length() > 10) {
			return "Class is not valid";
		} else if (student.getProvince().length() < 1 || student.getProvince().length() > 100) {
			return "Province is not valid";
		}

		return ExamResultValidation.check(student.getExamResult());
	}
}
