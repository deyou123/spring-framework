package com.example.config;

import com.example.po.Pig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author DeYou
 * @date 2023/4/2
 */
@Configuration
@ComponentScan("com.example.config")
public class AppConfig {

	@Bean(initMethod = "pigInitMethod",destroyMethod = "pigDestroyMethod")
	public Pig Pig(){
		return new Pig();
	}
}