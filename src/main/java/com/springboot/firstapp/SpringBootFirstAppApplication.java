package com.springboot.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFirstAppApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringBootFirstAppApplication.class, args);
		System.out.println(context.getBean(HelloWorld.class).helloWorld());
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for(String beanDefinitionName : beanDefinitionNames){
			System.out.println("----- " + beanDefinitionName + " ------");
		}
		context.close();
	}

	@Bean
	public HelloWorld helloWorld(){
		return new HelloWorld();
	}

}
