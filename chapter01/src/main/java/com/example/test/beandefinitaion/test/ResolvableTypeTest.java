package com.example.test.beandefinitaion.test;

import com.example.po.User;
import org.springframework.core.ResolvableType;

import java.util.ArrayList;

/**
 * @author DeYou
 * @date 2023/4/3
 */
public class ResolvableTypeTest {

	public void test1(){
		class UserList extends ArrayList<User> {}
		// 使用 ResolvableType 获取 UserList 类的泛型类型
		ResolvableType resolvableType = ResolvableType.forClass(UserList.class);
		ResolvableType genericType = resolvableType.getGeneric(0);
		System.out.println(genericType.getType()); // class com.example.User
	}
}