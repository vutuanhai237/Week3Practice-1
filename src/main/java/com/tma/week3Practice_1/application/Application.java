package com.tma.week3Practice_1.application;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tma.week3Practice_1.model.StudentBean;
import com.tma.week3Practice_1.validation.StudentValidation;

@ComponentScan({ "com.tma.week3Practice_1.model" })
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		// Use only annotation
		StudentBean student = context.getBean("studentBean", StudentBean.class);
		do {
			student = input(student);
			String validation = StudentValidation.check(student);
			if (validation != "valid") {
				System.out.println(validation);
			}
		} while (StudentValidation.check(student) != "valid");
		System.out.println(student.toString());

	}

	public static StudentBean input(StudentBean student) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter student's name: ");
		String name = scn.nextLine();
		System.out.println("Enter student's age (1 - 100): ");
		int age = Integer.parseInt(scn.nextLine());
		System.out.println("Enter student's province: ");
		String province = scn.nextLine();
		System.out.println("Enter student's class: ");
		String classes = scn.nextLine();

		System.out.println("Enter 3 student's point (1 - 10): ");
		float point1 = (scn.nextFloat());
		float point2 = (scn.nextFloat());
		float point3 = (scn.nextFloat());
		student.getExamResult().setPoint1(point1);
		student.getExamResult().setPoint2(point2);
		student.getExamResult().setPoint3(point3);
		student.setName(name);
		student.setAge(age);
		student.setProvince(province);
		student.setClasses(classes);
		return student;
	}
}
