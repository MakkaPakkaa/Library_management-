package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hry.bean.AdminBean;
import com.hry.dao.AdminDao;
import com.hry.dao.BookDao;

/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset = UTF-8");
		BookDao bookdao = new BookDao();
		//为了区分借书和还书的功能，设置tip，tip为1，表示借书
		int tip = Integer.parseInt(request.getParameter("tip"));
		if (tip == 1) {
			//获取图书ID
			int bid = Integer.parseInt(request.getParameter("bid"));
			HttpSession session = request.getSession();
			AdminBean admin = new AdminBean();
			//获取到存入session的aid读者id
			String aid = (String)session.getAttribute("aid");
			AdminDao admindao = new AdminDao();
			//通过aid获取到读者信息
			admin = admindao.get_AidInfo2(aid);
			//将借阅记录存入数据库
			bookdao.borrowBook(bid, admin);
			response.sendRedirect("select.jsp");
		} else {
			//还书功能，获取借阅记录的hid
			int hid = Integer.parseInt(request.getParameter("hid"));
			//还书在管理员和读者界面都有，为了区分，设置了show字段，show为1表示读者界面
			int show = Integer.parseInt(request.getParameter("show"));
			//调用还书函数，改变status字段
			bookdao.borrowBook2(hid);
			if (show==1) {
				response.sendRedirect("borrow.jsp");
			} else {
				response.sendRedirect("admin_borrow.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
