package com.example.test;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author DeYou
 * @date 2023/4/3
 */

public class BeanDefinitionTest {

	Logger logger = LoggerFactory.getLogger( BeanDefinitionTest.class );

	@Test
	public void test(){

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName( "com.example.po.User" );

		MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.add( "id",1 );
		propertyValues.add( "userName","Tom");
		beanDefinition.setPropertyValues(   propertyValues );



	}
	@Test
	public void testXml(){
		//创建一个简单BeanDefinitionRegistry
		SimpleBeanDefinitionRegistry  beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
		//传入beanDefinitionRegistry
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
		//加载配置文件
		reader.loadBeanDefinitions( "classpath:spring-config.xml" );

		for (String beanDefinitionName : beanDefinitionRegistry.getBeanDefinitionNames()) {
			logger.info( beanDefinitionName );
		}


	}
}