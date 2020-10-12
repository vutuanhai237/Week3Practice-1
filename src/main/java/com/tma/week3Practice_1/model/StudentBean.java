package com.tma.week3Practice_1.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentBean {
	@Autowired
	private ExamResultBean examResult;
	private int student_id;
	private String name;
	private int age;
	private String province;
	private String classes;

	public ExamResultBean getExamResult() {
		return examResult;
	}

	public void setExamResult(ExamResultBean examResult) {
		this.examResult = examResult;
	}

	public StudentBean(ExamResultBean examResult) {
		this.setExamResult(examResult);
	}

	public StudentBean() {
		this.name = "";
		this.age = 0;
		this.province = "";
		this.classes = "";
	}

	public StudentBean(String name) {
		this.name = name;
	}

	public StudentBean(String name, int age, String province, String classes) {
		this.name = name;
		this.age = age;
		this.province = province;
		this.classes = classes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		String result = "";
		result = "Name: " + this.getName() + ", age: " + this.getAge() + ", class: " + this.getClasses()
				+ ", province: " + this.getProvince() + ", GPA: " + this.examResult.getGPA() + "\n";
		result += this.examResult.toString();
		return result;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
}
