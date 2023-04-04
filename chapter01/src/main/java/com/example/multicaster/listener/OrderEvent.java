package com.example.multicaster.listener;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * @author DeYou
 * @date 2023/4/4
 */
public class OrderEvent extends ApplicationEvent {
	public OrderEvent(Object source) {
		super( source );
	}

	public OrderEvent(Object source, Clock clock) {
		super( source, clock );
	}
}