package com.example;

import com.example.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.support.SimpleInstantiationStrategy;

/**
 * @author DeYou
 * @date 2023/4/5
 */
public class ObjectFactoryTest {
	private static final Logger logger = LoggerFactory.getLogger(ObjectFactoryTest.class);
	public void test(){
		ObjectFactory<User> factory = ()->{
			return new User( "tom",22 );
		};
		User user = factory.getObject();
		System.out.println(user);
	}
	@Test
	public void testAbstractAutowireCapableBeanFactory() throws ClassNotFoundException {

		// 编写bean的定义
		RootBeanDefinition beanDefinition = new RootBeanDefinition();
		beanDefinition.setBeanClassName("com.example.po.User");
		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue("name","it楠老师");
		propertyValues.addPropertyValue("age",32);
		beanDefinition.setPropertyValues(propertyValues);
		beanDefinition.resolveBeanClass(Thread.currentThread().getContextClassLoader());


		// 我们模仿一个beanDefinition如何变成一个bean
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("user",beanDefinition);
		// 实例化
		SimpleInstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();
		User user = (User)instantiationStrategy.instantiate(beanDefinition, "user", beanFactory);
		// 属性填充
		BeanWrapper wrapper = new BeanWrapperImpl(user);
		wrapper.setPropertyValues(beanDefinition.getPropertyValues());
		logger.info("The user is [{}]",user);
		logger.info("The user is [{}]",user);

	}


}