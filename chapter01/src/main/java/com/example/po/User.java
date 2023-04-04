package com.example.po;


import com.example.annotation.MyComponent;

/**
 * @author DeYou
 * @date 2023/4/2
 */
@MyComponent
public class User {
	public User() {
		System.out.println(this.getClass().getName()+"被创建了");
	}

	private Long id;
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				'}';
	}
}