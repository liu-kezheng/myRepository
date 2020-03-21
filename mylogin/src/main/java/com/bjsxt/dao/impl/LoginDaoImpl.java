package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.dao.LoginDao;
import com.bjsxt.pojo.Person;
import com.bjsxt.util.JdbcUtil;

public class LoginDaoImpl implements LoginDao{
	
	//登录
	@Override
	public List<Person> checkLoginDao(String name, String idcard) {
		//声明JDBC对象
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Person> list = null;
		try {
			//创建连接对象
			conn = JdbcUtil.getConnection();
			//创建sql命令对象
			ps = JdbcUtil.getPreparedStatement(conn, "select * from person where name=? and idcard=?");
			//给占位符赋值
			ps.setString(1, name);
			ps.setString(2, idcard);
			//执行
			rs = ps.executeQuery();
			list = new ArrayList<>();
			while(rs.next()){
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setSex(rs.getInt("sex"));
				p.setIdcard(rs.getString("idcard"));
				p.setAddress(rs.getString("address"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(rs, ps, conn);
		}
	
		return list;
	}
	
}