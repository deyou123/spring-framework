package com.example;

import com.example.config.AppConfig;
import com.example.po.Pig;
import com.example.po.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author DeYou
 * @date 2023/4/5
 */
public class AppTest {

	@Test
	public void testHierarchicalBeanFactory(){
		// 创建一个核心的工厂
		DefaultListableBeanFactory parent = new DefaultListableBeanFactory();
		parent.registerSingleton("user",new User("楠老师",31));
		// 创建一个子工厂工厂，独自管理各个层级的内容
		DefaultListableBeanFactory child = new DefaultListableBeanFactory();
		// 设置父子关联关系
		child.setParentBeanFactory(parent);
		// 子工厂可以访问父工厂的bean
		System.out.println(child.containsLocalBean("user")); //查看本地工厂找不到
		System.out.println(child.containsBean("user"));  //从付工厂中找到
		System.out.println(child.getBean("user"));
	}

	@Test
	public void testBeanFactoryProcessor(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );
		User user = (User) context.getBean( User.class );
		System.out.println(user);

	}

	@Test
	public void testInitMethod(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class );
		System.out.println("打印输出Pig对象"+ context.getBean( Pig.class ));
		context.close();

	}

}