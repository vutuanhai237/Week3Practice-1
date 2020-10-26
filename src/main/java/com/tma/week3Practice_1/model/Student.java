package com.tma.week3Practice_1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tma.week3Practice_1.utils.Constant;

@Entity
@Table(name = "Student")
@Component
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "AGE")
	private int age;
	@Column(name = "PROVINCE")
	private String province;
	@Column(name = "CLASSES")
	private String classes;
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id", referencedColumnName = "id")
	private ExamResult examResult;

	@Autowired
	public ExamResult getExamResult() {
		return examResult;
	}

	public void setExamResult(ExamResult examResult) {
		this.examResult = examResult;
	}

	public Student(ExamResult examResult) {
		this.setExamResult(examResult);
	}

	public Student() {
		this.name = "";
		this.age = 0;
		this.province = "";
		this.classes = "";
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, int age, String province, String classes) {
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
				+ ", province: " + this.getProvince() + ", GPA: " + this.examResult.getGPA() + ", ";
		result += this.examResult.toString();
		return result;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String check() throws Exception {
		try {
			if (this.getName().length() < 1 || this.getName().length() > 30) {
				return Constant.STUDENT_NAME_IS_NOT_VALID;
			} else if (this.getAge() < 0 || this.getAge() > 100) {
				return Constant.STUDENT_AGE_IS_NOT_VALID;
			} else if (this.getClasses().length() < 1 || this.getClasses().length() > 10) {
				return Constant.STUDENT_CLASS_IS_NOT_VALID;
			} else if (this.getProvince().length() < 1 || this.getProvince().length() > 100) {
				return Constant.STUDENT_PROVINCE_IS_NOT_VALID;
			}

			return this.getExamResult().check();
		} catch (Exception e) {
			throw new Exception(Constant.STUDENT_IS_NULL);
		}
	}
}
