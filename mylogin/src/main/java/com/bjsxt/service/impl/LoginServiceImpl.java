package com.bjsxt.service.impl;

import java.util.List;

import com.bjsxt.dao.impl.LoginDaoImpl;
import com.bjsxt.pojo.Person;
import com.bjsxt.service.LoginService;

public class LoginServiceImpl implements LoginService{
	LoginDaoImpl ld = new LoginDaoImpl();
	
	@Override
	public List<Person> checkLoginService(String name, String idcard) {
		
		return ld.checkLoginDao(name, idcard);
	}

}
