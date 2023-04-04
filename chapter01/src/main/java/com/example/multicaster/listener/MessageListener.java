package com.example.multicaster.listener;

import org.springframework.context.ApplicationListener;

/**
 * @author DeYou
 * @date 2023/4/4
 */
public class MessageListener implements ApplicationListener<OrderEvent> {
	@Override
	public void onApplicationEvent(OrderEvent event) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(event.getSource() + "-->短信发送！");
	}
}