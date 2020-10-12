package com.tma.week3Practice_1.model;

import org.springframework.stereotype.Component;

@Component
public class ExamResultBean {
	private float point1;
	private float point2;
	private float point3;

	public ExamResultBean() {
		this.point1 = this.point2 = this.point3 = 0f;
	}

	public ExamResultBean(float point1, float point2, float point3) {
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}

	public float getGPA() {
		return (this.point1 + this.point2 + this.point3) / 3;
	}

	public String toString() {
		return "Toán: " + this.point1 + ", Lý: " + this.point2 + ", Anh: " + this.point3;
	}

	public float getPoint1() {
		return point1;
	}

	public void setPoint1(float point1) {
		this.point1 = point1;
	}

	public float getPoint2() {
		return point2;
	}

	public void setPoint2(float point2) {
		this.point2 = point2;
	}

	public float getPoint3() {
		return point3;
	}

	public void setPoint3(float point3) {
		this.point3 = point3;
	}
}