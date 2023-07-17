package com.shetech.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




import java.util.Arrays;

@SpringBootApplication
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(EmployeeManagerApplication.class, args);
		}
		catch (Exception e) {
				e.printStackTrace();
			}
	}
	@Configuration
	public class WebConfig
	{
		@Bean
		public WebMvcConfigurer corsConfigurer()
		{
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**").allowedOrigins("http://localhost:4200");
				}
			};
		}
	}
}
