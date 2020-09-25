package com.hry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hry.bean.TypeBean;
import com.hry.dbUtils.DbUtil;


/**
 * 图书分类的类
 */
public class TypeDao {
	/**
	 * 获取所有图书类型的信息，返回数组形式
	 * @return
	 */
	public ArrayList<TypeBean> get_ListInfo(){
		ArrayList<TypeBean> tag_Array = new ArrayList<TypeBean>();
		Connection conn = DbUtil.getConn();
		String sql = "select * from booktype";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				TypeBean tag = new TypeBean();
				tag.setTid(rs.getInt("tid"));
				tag.setName(rs.getString("name"));
				tag_Array.add(tag);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tag_Array;
	}
	/**
	 * 修改图书分类的信息
	 * @param tid
	 * @param name
	 */
	public void updateTypeBook(int tid, String name) {
		Connection conn = DbUtil.getConn();
		String sql = "update booktype set name=? where tid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setInt(2, tid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 添加一个图书分类
	 * @param name
	 */
	public void addBookType(String name) {
		Connection conn = DbUtil.getConn();
		String sql = "insert into booktype(name) values(?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);;
			rs = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除一个图书分类
	 * @param tid
	 */
	public void deleteBookType(int tid) {
		Connection conn = DbUtil.getConn();
		String sql = "delete from booktype where tid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, tid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
