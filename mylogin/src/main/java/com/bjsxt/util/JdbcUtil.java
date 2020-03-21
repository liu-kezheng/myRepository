package com.bjsxt.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		Properties p = new Properties();
		InputStream is = JdbcUtil.class.getResourceAsStream("/db.properties");
		
		try{
			//加载配置文件
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//获取Connection对象
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//获取PreparedStatement对象
	public static PreparedStatement getPreparedStatement(Connection conn,String sql){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	};
	
	//关闭资源
	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
