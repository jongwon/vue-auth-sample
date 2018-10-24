package com.sp.sample.authserver1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@EnableWebMvc
@SpringBootApplication
public class AuthServer1Application  {

	public static void main(String[] args) {
		SpringApplication.run(AuthServer1Application.class, args);
	}



	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("POST, GET, OPTIONS, DELETE, PUT")
						.allowCredentials(true)
						.maxAge(3600);
			}
		};
	}


}
