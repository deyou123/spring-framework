import com.example.config.AppConfig;
import com.example.po.User;
import com.example.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Objects;

/**
 * @author DeYou
 * @date 2023/4/2
 */

public class SpringTest {

	private static final Logger logger = LoggerFactory.getLogger(SpringTest.class);
	@Test
	public void testAnnnoConfig(){
		//第一种方式: 使用注解定义扫描路径,在AppConfig配置类中使用@ComponentSacn注解定义扫描路径
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		userService.run();
	}

	@Test
	public void test2(){
		//第二种方式: 直接手动定义扫描路径  - 不使用
		AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext("com.example");
		UserService userService2 = (UserService) context2.getBean("userService");
		userService2.run();

	}

	@Test
	public void test3(){
		//第三种方式: 使用配置文件 - 不使用
		ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext("spring-config.xml");
		UserService userService3 = (UserService) context3.getBean("userService");
		userService3.run();

	}


	@Test
	public void testBeanPostProcessor(){
		//第一种方式: 使用注解定义扫描路径,在AppConfig配置类中使用@ComponentSacn注解定义扫描路径
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( AppConfig.class);
		ConfigurableEnvironment environment = context.getEnvironment();
		logger.info( "Java_HOME -->{}",environment.getProperty( "JAVA_HOME" ) );

		User user = (User) context.getBean( User.class);
		if(	Objects.isNull(user)){
			throw new RuntimeException("容器未创建对象");
		}


	}

	@Test
	public void test(){
		GenericXmlApplicationContext context = new GenericXmlApplicationContext( "classpath:spring-config.xml" );
		User bean = context.getBean( User.class );
		System.out.println(bean);


	}


}
