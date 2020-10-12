package com.tma.week3Practice_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		// Use only annotation
		StudentBean student = context.getBean("studentBean", StudentBean.class);
		student.setName("Hai1");
		student.setAge(10);
		student.setProvince("Gia Lai");
		student.setClasses("12C1");
		ScoreBean score = context.getBean("scoreBean", ScoreBean.class);
		score.setName("Toan");
		score.setPoint(10.0);
		System.out.println(student.toString());

	}
}
