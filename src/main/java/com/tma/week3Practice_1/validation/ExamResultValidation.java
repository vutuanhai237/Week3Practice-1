package com.tma.week3Practice_1.validation;

import com.tma.week3Practice_1.model.ExamResult;

public class ExamResultValidation {
	public static String check(ExamResult examResult) throws Exception {
		try {
			if (checkPoint(examResult.getPoint1()) && checkPoint(examResult.getPoint2())
					&& checkPoint(examResult.getPoint3())) {
				return "valid";

			}
			return "Exam result is not valid (1 - 10)";
		} catch (Exception e) {
			throw new Exception("Exam result is null");
		}

	}

	public static boolean checkPoint(float point) {

		if (point < 0 || point > 10) {
			return false;
		}
		return true;
	}
}
