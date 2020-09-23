package com.hry.dbUtils;

import java.sql.Connection;

public class TestDb {

	public static void main(String[] args) {
		Connection conn = DbUtil.getConn();
		if(conn != null){
            System.out.println("测试：数据库连接成功！");
        }else{
            System.out.println("测试：数据库连接失败！");
        }
	}
}
