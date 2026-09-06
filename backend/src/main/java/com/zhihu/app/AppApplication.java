package com.zhihu.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = {"com.zhihu.app","control","service","model","java"})
public class AppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppApplication.class, args);


	}

}
