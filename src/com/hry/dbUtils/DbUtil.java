package com.hry.dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	private static String username = null;
	private static String password = null;
	private static String url = null;
	private static String driver = null;
	private static Connection conn = null;
	private static Properties pros = new Properties();
	// 1、静态代码块
	static {

		// 2、类加载器读取外部资源文件
		InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			// 3、读取
			pros.load(is);
			// 4、获取值
			username = pros.getProperty("jdbc.username");
			password = pros.getProperty("jdbc.password");
			url = pros.getProperty("jdbc.url");
			driver = pros.getProperty("jdbc.driver");

			// 5、加载驱动
			Class.forName(driver);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接的方法
	 */
	public static Connection getConn() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return conn;
	}

	/**
	 * 关闭连接的方法
	 */
//	public static void closeConn() {
//
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    
//	}
	public void CloseDB(ResultSet rs, PreparedStatement stm){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stm!=null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
