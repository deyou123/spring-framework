package com.example.tool;

import com.example.po.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author DeYou
 * @date 2023/4/3
 */
public class TestTool {
	Logger logger = LoggerFactory.getLogger( Test.class );

	@Test
	public void testIntrosSpector1() throws IntrospectionException {

		BeanInfo beanInfo = Introspector.getBeanInfo( User.class, Object.class );
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			logger.info( "{}",propertyDescriptor.getPropertyType()  );
		}


	}

	@Test
	public void testIntrosSpector12() throws IntrospectionException, InvocationTargetException, IllegalAccessException {

		User user = new User();
		PropertyDescriptor propertyDescriptor = new PropertyDescriptor( "userName",User.class );
		Method writeMethod = propertyDescriptor.getWriteMethod();
		writeMethod.invoke( user,"tom" );
		System.out.println(user);

	}
	@Test
	public void testBeanUtils() throws InvocationTargetException, IllegalAccessException {
		User user = new User();

		BeanUtils.setProperty(user,"userName","tom");
		logger.info( "{}",user );
	}
}