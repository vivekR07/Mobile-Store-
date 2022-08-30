package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.mapper.MobilePhoneMapper;
import com.example.demo.mapper.MobilePhoneMapperImpl;

@SpringBootApplication
public class MobileStoreLab01Application {

	public static void main(String[] args) {
		SpringApplication.run(MobileStoreLab01Application.class, args);
	}
	@Bean
	public MobilePhoneMapper getMapper() {
		return new MobilePhoneMapperImpl();
	}

}
