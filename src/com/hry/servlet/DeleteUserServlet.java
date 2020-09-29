package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hry.dao.AdminDao;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
//界面无post一般写get上
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//删除读者信息
		//Integer 类：parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析
		int aid = Integer.parseInt(request.getParameter("aid"));
		AdminDao admindao = new AdminDao();
		admindao.deleteUser(aid);
		response.sendRedirect("admin_user.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
