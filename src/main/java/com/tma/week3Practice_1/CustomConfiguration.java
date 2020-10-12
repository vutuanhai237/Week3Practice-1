package com.tma.week3Practice_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * Created by Turreta.com on 8/7/2017.
 */
@Configuration
public class CustomConfiguration {
	@Bean
	@Order(1)
	public ScoreBean a() {
		return new ScoreBean("Toán", 9);
	}

	@Bean
	@Order(2)
	public ScoreBean b() {
		return new ScoreBean("2", 7);
	}

	@Bean
	@Order(3)
	public ScoreBean c() {
		return new ScoreBean("3", 8);
	}

	@Bean
	@Order(4)
	public ScoreBean d() {
		return new ScoreBean("4", 9);
	}
}
