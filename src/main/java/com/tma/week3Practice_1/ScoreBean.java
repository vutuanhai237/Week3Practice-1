package com.tma.week3Practice_1;

public class ScoreBean {
	private String name;
	private double point;

	public ScoreBean(String name, int point) {
		this.name = name;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String toString() {
		return "Name: " + this.getName() + ", point: " + this.getPoint();
	}
}