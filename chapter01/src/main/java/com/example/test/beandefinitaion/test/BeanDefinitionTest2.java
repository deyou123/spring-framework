package com.example.test.beandefinitaion.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author DeYou
 * @date 2023/4/3
 */

public class BeanDefinitionTest2 {
	Logger logger = LoggerFactory.getLogger( BeanDefinitionTest2.class );


	@Test
	public void testBeanWrapper() throws ClassNotFoundException {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName( "com.example.po.User" );

		MutablePropertyValues propertyValues = new MutablePropertyValues();

		propertyValues.addPropertyValue( new PropertyValue( "id",1 ) );
		propertyValues.addPropertyValue( new PropertyValue( "userName","Tom" ) );
		beanDefinition.setPropertyValues(propertyValues);
		Class<?> clazz = Class.forName( beanDefinition.getBeanClassName() );
		//实例化并做属性填充
		BeanWrapper beanWrapper = new BeanWrapperImpl(clazz);
		//属性填充
		beanWrapper.setPropertyValues( beanDefinition.getPropertyValues() );

		//获取实例
		Object beanInstance = beanWrapper.getWrappedInstance();

		logger.info( "obj--> {}",beanInstance );


	}

}