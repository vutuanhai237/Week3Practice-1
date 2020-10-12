package com.tma.week3Practice_1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentBean {
	@Autowired
	private List<ScoreBean> scores;
	private int student_id;
	private String name;
	private int age;
	private String province;
	private String classes;

	public List<ScoreBean> getScores() {
		return scores;
	}

	public void setScores(List<ScoreBean> scores) {
		this.scores = scores;
	}

	public void addScores(ScoreBean score) {
		this.scores.add(score);
	}

	public StudentBean(List<ScoreBean> scores) {
		this.setScores(scores);
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
				+ ", province: " + this.getProvince() + ", GPA: " + this.getGPA() + "\n";
		for (ScoreBean score : this.getScores()) {
			result += score.toString() + "\n";
		}

		return result;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public double getGPA() {
		double result = 0;
		for (ScoreBean score : this.getScores()) {
			result += score.getPoint();
		}
		return result / this.getScores().size();
	}
}
