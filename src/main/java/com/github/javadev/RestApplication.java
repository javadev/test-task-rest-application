package com.github.javadev;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class RestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new RestApplication()
				.configure(new SpringApplicationBuilder(RestApplication.class))
				.run(args);
	}

}
