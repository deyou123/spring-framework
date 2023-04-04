package com.example.multicaster;

import com.example.multicaster.listener.EmailListener;
import com.example.multicaster.listener.MessageListener;
import com.example.multicaster.listener.OrderEvent;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.util.ErrorHandler;

import java.util.concurrent.Executors;

/**
 * @author DeYou
 * @date 2023/4/4
 */
public class Multicastest {
	private Logger logger = LoggerFactory.getLogger( Multicastest.class );
	@Test
	public void testEventMulticaster(){
		SimpleApplicationEventMulticaster multicaster =
				new SimpleApplicationEventMulticaster();

		multicaster.setTaskExecutor( Executors.newFixedThreadPool( 10 ) );

		// 设置异常处理器
		multicaster.setErrorHandler(new ErrorHandler() {
			@Override
			public void handleError(Throwable t) {
				// 做补偿处理，发送通知等等操作
				System.out.println("有异常了，快来处理");
				logger.error("此处发生了异常-->",t);
			}
		});
		multicaster.addApplicationListener(  new MessageListener() );
		multicaster.addApplicationListener(  new MessageListener() );
		multicaster.addApplicationListener(  new EmailListener() );
		multicaster.addApplicationListener(  new MessageListener() );

		//使用多播器发布事件
		multicaster.multicastEvent( new OrderEvent( this ) );
	}
}