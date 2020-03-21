package com.bjsxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.pojo.Person;
import com.bjsxt.service.LoginService;
import com.bjsxt.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet{
	//获取业务层对象
	LoginService ls = new LoginServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String name = req.getParameter("name");
		String idcard = req.getParameter("idcard");
		
		String method = req.getMethod();
		//获取URL
		StringBuffer url = req.getRequestURL();
		//获取URI
		String uri = req.getRequestURI();
		System.out.println(uri);
		
		//处理请求信息
		List<Person> list = ls.checkLoginService(name, idcard);
		System.out.println(list);
		//响应处理结果
		if(!list.isEmpty()){
			resp.sendRedirect("/ToLogin/success.jsp");
			return;
		}else{
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
			return;
		}
	}
}
