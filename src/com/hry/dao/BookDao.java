package com.hry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.hry.bean.AdminBean;
import com.hry.bean.BookBean;
import com.hry.bean.HistoryBean;
import com.hry.dbUtils.DbUtil;

/**
 * 关于图书连接数据库的所有操作的类
 */
public class BookDao {
	/**
	 * 添加图书信息，传入所有的信息
	 * 
	 */
	public void addBook(String card ,String name ,String type , String autho ,String press, int num ) {
		//连接数据库
		Connection conn = DbUtil.getConn();
		//SQL
		String sql = "insert into book(card,name,type,autho,press,num) values(?,?,?,?,?,?)";
		int rs = 0;
		PreparedStatement stm = null;
		try {
			//预编译SQL，减少sql执行
			stm = conn.prepareStatement(sql);
			//添加
			stm.setString(1, card);
			stm.setString(2, name);
			stm.setString(3, type);
			stm.setString(4, autho);
			stm.setString(5, press);
			stm.setInt(6, num);
			//执行更新
			rs = stm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 获取所有的图书信息，返回的是ArrayList数组形式
	 * 访问 ArrayList 中的元素可以使用 get() 方法：
	 *修改 ArrayList 中的元素可以使用 set() 方法：
	 *删除 ArrayList 中的元素可以使用 remove() 方法：
	 */
	public ArrayList<BookBean> get_ListInfo(){
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		Connection conn = DbUtil.getConn();
		String sql = "select * from book";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				BookBean tag = new BookBean();
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				tag_Array.add(tag);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tag_Array;
	}
	/**
	 * 获取借阅记录的全部信息，传入的条件有status，aid，表示搜索正在借阅的，或者已经还书的信息，aid代表当前登录用户
	 *
	 */
	public ArrayList<HistoryBean> get_HisoryListInfo(int status,String aid){
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		Connection conn = DbUtil.getConn();
		String sql = "select * from history where aid = '"+ aid +"' and status = '"+ status+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				HistoryBean tag = new HistoryBean();
				tag.setHid(rs.getInt("hid"));
				tag.setAid(rs.getInt("aid"));
				tag.setBid(rs.getInt("bid"));
				tag.setBookname(rs.getString("bookname"));
				tag.setCard(rs.getString("card"));
				tag.setAdminname(rs.getString("adminname"));
				tag.setUsername(rs.getString("username"));
				tag.setBegintime(rs.getString("begintime"));
				tag.setEndtime(rs.getString("endtime"));
				tag.setStatus(rs.getInt("status"));
				tag_Array.add(tag);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tag_Array;
	}
	/**
	 * 获取借阅记录的全部信息，传入的条件有status，表示搜索正在借阅的，或者已经还书的信息
	 *
	 */
	public ArrayList<HistoryBean> get_HistoryListInfo2(int status){
		ArrayList<HistoryBean> tag_Array = new ArrayList<HistoryBean>();
		Connection conn = DbUtil.getConn();
		String sql = "select * from history where status='"+status+"'";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				HistoryBean tag = new HistoryBean();
				tag.setHid(rs.getInt("hid"));
				tag.setAid(rs.getInt("aid"));
				tag.setBid(rs.getInt("bid"));
				tag.setBookname(rs.getString("bookname"));
				tag.setCard(rs.getString("card"));
				tag.setAdminname(rs.getString("adminname"));
				tag.setUsername(rs.getString("username"));
				tag.setBegintime(rs.getString("begintime"));
				tag.setEndtime(rs.getString("endtime"));
				tag.setStatus(rs.getInt("status"));
				tag_Array.add(tag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tag_Array;
	}
	/**
	 * 获取单个图书的信息，根据传入的bid来查找，返回一个BookBean数据类型
	 *
	 */
	public BookBean get_BookInfo(int bid) {
		BookBean tag = new BookBean();
		Connection conn = DbUtil.getConn();
		String sql = "select * from book where bid = '"+ bid +"' ";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()) {
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tag;
	}
	/**
	 * 修改图书的信息，bid作为条件，
	 */
	public void updateBook(int bid, String card, String name, String type, String autho, String press, int num) {
		// TODO Auto-generated method stub
		Connection conn = DbUtil.getConn();
		String sql = "update book set name=?,card=?,type=?,autho=?,press=?,num=? where bid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, card);
			stm.setString(3, type);
			stm.setString(4, autho);
			stm.setString(5, press);
			stm.setInt(6, num);
			stm.setInt(7, bid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除图书信息，根据传入的bid作为条件
	 */
	public void deleteBook(int bid) {
		Connection conn = DbUtil.getConn();
		String sql = "delete from book where bid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, bid);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 用户查找图书，根据输入的名称，使用like进行模糊查询，然后返回一个ArrayList数组类型
	 */
	public ArrayList<BookBean> getLikeList(String name){
		ArrayList<BookBean> tag_Array = new ArrayList<BookBean>();
		Connection conn = DbUtil.getConn();
		String sql = "select * from book where name like '%" + name+"%'";
		PreparedStatement stm = null;
		ResultSet rs =null;
		try {
			stm = conn.prepareStatement(sql);
			rs = stm.executeQuery();
			while(rs.next()){
				BookBean tag = new BookBean();
				tag.setBid(rs.getInt("bid"));
				tag.setName(rs.getString("name"));
				tag.setCard(rs.getString("card"));
				tag.setType(rs.getString("type"));
				tag.setAutho(rs.getString("autho"));
				tag.setPress(rs.getString("press"));
				tag.setNum(rs.getInt("num"));
				tag_Array.add(tag);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tag_Array;
	}
	/**
	 * 图书借阅函数，根据传入bid图书id，adminbean当前登录用户的信息，在借阅记录数据表中新插入一条记录
	 *
	 */
	public void borrowBook(int bid, AdminBean adminbean) {
		BookBean bookbean = new BookBean();
		bookbean = this.get_BookInfo(bid);
		//生成日期功能
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		//生成借阅开始时间
		String begintime = ""+ year +"-"+month +"-"+day;
		month = month +1;
		//生成截至还书日期
		String endtime = ""+year+"-"+month+"-"+day;
		Connection conn = DbUtil.getConn();
		String sql = "insert into history(aid,bid,card,bookname,adminname,username,begintime,endtime,status) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stm = null;
		int rs = 0;
		try {
			stm = conn.prepareStatement(sql);
			stm.setInt(1, adminbean.getAid());
			stm.setInt(2, bookbean.getBid());
			stm.setString(3, bookbean.getCard());
			stm.setString(4, bookbean.getName());
			stm.setString(5, adminbean.getUsername());
			stm.setString(6, adminbean.getName());
			stm.setString(7, begintime);
			stm.setString(8, endtime);
			stm.setInt(9, 1);
			rs = stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 还书功能的函数，根据传入的hid借阅记录id，讲status字段的值改为0，并将还书日期改变为当前日期
	 * 
	 */
	public void borrowBook2(int hid) {
		//生成日期
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DATE);
		//生成还书日期
		String endtime = ""+year+"-"+month+"-"+day;
		Connection conn = DbUtil.getConn();
		String sql = "update history set endtime=?,status=? where hid=?";
		PreparedStatement stm = null;
		try {
			stm = conn.prepareStatement(sql);
			stm.setString(1, endtime);
			stm.setInt(2, 0);
			stm.setInt(3, hid);
			stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
