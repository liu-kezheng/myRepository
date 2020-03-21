package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Person;

public interface LoginService {
	List<Person> checkLoginService(String name,String idcard);
}
