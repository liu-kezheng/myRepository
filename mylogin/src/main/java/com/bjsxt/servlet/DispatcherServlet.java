package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.controller.LoginController;

public class DispatcherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String methodName = req.getParameter("methodName");
		toLogin(req, resp, methodName);
	}
	
	public static void toLogin(HttpServletRequest req, HttpServletResponse resp,String methodName){
		toLogin(req,resp,methodName,"com.bjsxt.controller.LoginController");
	}
	
	public static void toLogin(HttpServletRequest req, HttpServletResponse resp,String methodName,String path){
		Class<?> c1 = null;
		PrintWriter out = null;
		try {
			c1 = Class.forName(path);
			LoginController lc = (LoginController) c1.newInstance();
			Method m = c1.getDeclaredMethod(methodName, HttpServletRequest.class);
			String str = (String) m.invoke(lc,req);
			resp.setContentType("text/html;charset=utf-8");
			out = resp.getWriter();
			out.print(str);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
