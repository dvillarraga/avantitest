package com.avanti.swtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.avanti.swtest"})
public class SwtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwtestApplication.class, args);
	}

}
