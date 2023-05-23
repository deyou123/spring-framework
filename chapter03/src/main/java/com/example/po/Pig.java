package com.example.po;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author DeYou
 * @date 2023/4/7
 */
//@Component
public class Pig implements InitializingBean, DisposableBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@PostConstruct
	public void postConstruct(){
		System.out.println("这是@PostConstruct注解标注得方法");
	}

	//对象被从ioc容器中移除之前调用
	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy(销毁逻辑)注解");
	}


	private void pigInitMethod() {
		System.out.println("使用@Bean注解指定初始化执行");
	}

	private void pigDestroyMethod() {
		System.out.println("使用@Bean注解指定初始化和销毁方法执行");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("实现InitializingBean的afterPropertiesSet()初始方法");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("实现DisposableBean接口自定义销毁方法");
	}
}