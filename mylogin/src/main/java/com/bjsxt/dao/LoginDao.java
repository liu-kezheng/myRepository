package com.bjsxt.dao;

import java.util.List;

import com.bjsxt.pojo.Person;

public interface LoginDao {
	//根据用户名和身份证号登录
	List<Person> checkLoginDao(String name,String idcard);
	
}
