package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DeYou
 * @date 2023/4/2
 */
@Configuration
@ComponentScan("com.example.service")
public class AppConfig {


	@Bean
	public MyBeanPostProcessor myBeanPostProcessor(){
		return new MyBeanPostProcessor();
	}

	@Bean
	public MyComponentBeanPostProcessor myComponentBeanPostProcessor() {
		return new MyComponentBeanPostProcessor();
	}

	@Bean
	public MyComponentBeanFactoryPostProcessor myComponentBeanFactoryPostProcessor() {
		return new MyComponentBeanFactoryPostProcessor();
	}
}