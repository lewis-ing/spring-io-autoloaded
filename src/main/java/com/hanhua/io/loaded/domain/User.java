package com.hanhua.io.loaded.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String userName;
	
	private String password;
	
	private int age;
	
	private String address;
	
	private String homePage;
	
	private String email;
	
	private String loginName;

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public int getAge() {
		return age;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public User setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getHomePage() {
		return homePage;
	}

	public User setHomePage(String homePage) {
		this.homePage = homePage;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getLoginName() {
		return loginName;
	}

	public User setLoginName(String loginName) {
		this.loginName = loginName;
		return this;
	}

	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
