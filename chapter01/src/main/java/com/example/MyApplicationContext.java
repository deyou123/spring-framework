package com.example;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author DeYou
 * @date 2023/4/6
 */
public class MyApplicationContext extends AnnotationConfigApplicationContext {

	// 此处完美继承父类的功能
	public  MyApplicationContext(Class<?>... componentClasses) {
		super(componentClasses);
	}

	@Override
	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		// 此处我们获取到了beanFactory对象
		// 通过调用beanFactory的API可以进行任何的操作。
		if (beanFactory instanceof DefaultListableBeanFactory){
			System.out.println(true);
		}
	}
}
