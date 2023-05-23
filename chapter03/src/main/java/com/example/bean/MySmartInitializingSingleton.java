package com.example.bean;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author DeYou
 * @date 2023/4/7
 */
@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("所有的Bean 已经被实例化了");
	}
}