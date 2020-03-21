package com.bjsxt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.bjsxt.pojo.Person;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;
import com.google.gson.Gson;

public class LoginController {
	//获取业务层对象
	LoginService ls = new LoginServiceImpl();
	
	public String login(HttpServletRequest req) throws IOException, ServletException{
		req.setCharacterEncoding("utf-8");
		//获取请求信息
		String name = req.getParameter("name");
		String idcard = req.getParameter("idcard");
		
		//处理请求信息
		List<Person> list = ls.checkLoginService(name, idcard);
		System.out.println(list);
		
		Gson gson = new Gson();
		return gson.toJson(list);
	}
}
