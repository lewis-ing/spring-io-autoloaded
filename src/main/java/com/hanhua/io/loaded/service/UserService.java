package com.hanhua.io.loaded.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hanhua.io.loaded.domain.User;

@Service
public class UserService {

	private List<User> users = Arrays.asList(
			new User().setAddress("bj").setAge(30).setEmail("liuwenlong62555@126.com").setHomePage("https://github.com/lewis-ing").setId(Long.valueOf(1)).setLoginName("lewis").setPassword("123").setUserName("lewis"),
			new User().setAddress("bj").setAge(30).setEmail("liuwenlong62555@126.com").setHomePage("https://github.com/lewis-ing").setId(Long.valueOf(2)).setLoginName("lewis2").setPassword("123").setUserName("lewis2"),
			new User().setAddress("bj").setAge(30).setEmail("liuwenlong62555@126.com").setHomePage("https://github.com/lewis-ing").setId(Long.valueOf(3)).setLoginName("lewis3").setPassword("123").setUserName("lewis3"),
			new User().setAddress("bj").setAge(30).setEmail("liuwenlong62555@126.com").setHomePage("https://github.com/lewis-ing").setId(Long.valueOf(4)).setLoginName("lewis4").setPassword("123").setUserName("lewis4"),
			new User().setAddress("bj").setAge(30).setEmail("liuwenlong62555@126.com").setHomePage("https://github.com/lewis-ing").setId(Long.valueOf(5)).setLoginName("lewis5").setPassword("123").setUserName("lewis5"),
			new User().setAddress("bj").setAge(30).setEmail("liuwenlong62555@126.com").setHomePage("https://github.com/lewis-ing").setId(Long.valueOf(6)).setLoginName("lewis6").setPassword("123").setUserName("lewis6")
			);
	
	public User findUser(Long id){
		return users.stream().filter(
				(u) -> u.getId()== id
				).findAny().get();
	}
}
