package com.symphony.supervideo;

import com.symphony.supervideo.config.ScheduleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SuperVideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperVideoApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
	}

}
