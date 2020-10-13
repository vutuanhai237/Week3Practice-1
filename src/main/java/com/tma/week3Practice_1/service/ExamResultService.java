package com.tma.week3Practice_1.service;

import org.springframework.stereotype.Service;

import com.tma.week3Practice_1.model.ExamResult;
import com.tma.week3Practice_1.model.Student;

@Service
public interface ExamResultService {
	public Iterable<Student> getExamResults();

	public String updateExamResults(ExamResult examResult);

	public String createExamResults(ExamResult examResult);

	public String deleteExamResults(int examResult_id);

}
