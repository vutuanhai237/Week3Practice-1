package com.tma.week3Practice_1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
	@Bean
	public List<ScoreBean> getListScore() {
		List<ScoreBean> result = new ArrayList<ScoreBean>();
		result.add(new ScoreBean("Toan", 9));
		result.add(new ScoreBean("Anh", 10));
		result.add(new ScoreBean("Ly", 7));
		return result;
	}
}
