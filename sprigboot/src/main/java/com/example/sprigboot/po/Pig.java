package com.example.sprigboot.po;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author DeYou
 * @date 2023/4/7
 */
@Component
public class Pig {

	@PostConstruct
	public void postConstruct(){
		System.out.println("这是@PostConstruct注解标注得方法");
	}
	

	private void pigInit() {
		System.out.println("pigInit()方法执行");
	}
}