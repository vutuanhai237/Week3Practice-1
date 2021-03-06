package com.tma.week3Practice_1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.tma.week3Practice_1.utils.Constant;

@Entity
@Table(name = "examresult")
@Component
public class ExamResult {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	@Column(name = "POINT1")
	private float point1;
	@Column(name = "POINT2")
	private float point2;
	@Column(name = "POINT3")
	private float point3;

	@OneToOne(mappedBy = "examResult", fetch = FetchType.EAGER)
	private Student student;

	public ExamResult() {
		this.point1 = this.point2 = this.point3 = 0f;
	}

	public ExamResult(float point1, float point2, float point3) {
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}

	public float getGPA() {
		return (this.point1 + this.point2 + this.point3) / 3;
	}

	public String toString() {
		return "Math: " + this.point1 + ", Physical: " + this.point2 + ", English: " + this.point3;
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

	public String check() throws Exception {
		try {
			if (checkPoint(this.getPoint1()) && checkPoint(this.getPoint2()) && checkPoint(this.getPoint3())) {
				return Constant.VALID;

			}
			return Constant.EXAM_RESULT_NOT_VALID;
		} catch (Exception e) {
			throw new Exception(Constant.EXAM_RESULT_IS_NULL);
		}

	}

	public boolean checkPoint(float point) {
		if (point < 0 || point > 10) {
			return false;
		}
		return true;
	}
}