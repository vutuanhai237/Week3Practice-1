package com.tma.week3Practice_1.validation;

import com.tma.week3Practice_1.model.ExamResultBean;

public class ExamResultValidation {
	public static String check(ExamResultBean examResult) {
		if (!checkPoint(examResult.getPoint1()) || !checkPoint(examResult.getPoint2())
				|| !checkPoint(examResult.getPoint3())) {
			return "Exam result is not valid (1 - 10)";
		}
		return "valid";
	}

	public static boolean checkPoint(float point) {
		if (point < 0 || point > 10) {
			return false;
		}
		return true;
	}
}
