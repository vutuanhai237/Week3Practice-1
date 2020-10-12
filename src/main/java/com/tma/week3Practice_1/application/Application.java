package com.tma.week3Practice_1.application;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.tma.week3Practice_1.model.ExamResultBean;
import com.tma.week3Practice_1.model.StudentBean;

@ComponentScan({ "com.tma.week3Practice_1.model" })
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		// Use only annotation
		StudentBean student = context.getBean("studentBean", StudentBean.class);
		ExamResultBean examResult = context.getBean("examResultBean", ExamResultBean.class);
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter student's name: ");
		String name = scn.nextLine();
		System.out.println("Enter student's age: ");
		int age = Integer.parseInt(scn.nextLine());
		System.out.println("Enter student's province: ");
		String province = scn.nextLine();
		System.out.println("Enter student's class: ");
		String classes = scn.nextLine();

		System.out.println("Enter 3 student's point: ");
		float point1 = (scn.nextFloat());
		float point2 = (scn.nextFloat());
		float point3 = (scn.nextFloat());
		examResult.setPoint1(point1);
		examResult.setPoint2(point2);
		examResult.setPoint3(point3);

		student.setName(name);
		student.setAge(age);
		student.setProvince(province);
		student.setClasses(classes);

		System.out.println(student.toString());

	}
}
