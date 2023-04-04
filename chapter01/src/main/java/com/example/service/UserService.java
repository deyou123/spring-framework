package com.example.service;

import org.springframework.stereotype.Component;

/**
 * @author DeYou
 * @date 2023/4/2
 */
@Component
public class UserService {
	public UserService() {
		System.out.println(this.getClass().getName()+"->初始化了");
	}

	public void user(){
		System.out.println("user..........");
	}

	public void run(){
		System.out.println("我开始执行任务了");
	}
}