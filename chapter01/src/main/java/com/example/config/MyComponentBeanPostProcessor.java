package com.example.config;

import com.example.annotation.MyComponent;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author DeYou
 * @date 2023/4/2
 */
@Component
public class MyComponentBeanPostProcessor implements BeanPostProcessor , BeanFactoryAware {
	private BeanFactory beanFactory;
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean.getClass().isAnnotationPresent( MyComponent.class )){

			((DefaultListableBeanFactory) beanFactory).registerSingleton(beanName, bean);
		}

		return bean;
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}