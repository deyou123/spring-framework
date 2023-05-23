package com.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author DeYou
 * @date 2023/4/6
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("postProcessBeanFactory");
		//获取BeanDefinition
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("pig");
		System.out.println("修改属性name值");
		beanDefinition.getPropertyValues().add("name", "tom");

	}


}