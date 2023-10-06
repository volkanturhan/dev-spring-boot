package com.volkanturhan.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		scanBasePackages = {"com.volkanturhan.springcoredemo","util"}
//)

@SpringBootApplication(
		scanBasePackages = {"com.volkanturhan.springcoredemo","util"}
)
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}
}
