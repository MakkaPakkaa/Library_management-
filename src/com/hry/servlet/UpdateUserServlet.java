package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hry.dao.AdminDao;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset= UTF-8");
		//修改读者信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		//Integer 类：parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析
		//借阅最大天数
		int max_num = Integer.parseInt(request.getParameter("max_num"));
		//最大可借数
		int lend_num = Integer.parseInt(request.getParameter("lend_num"));
		//用户id
		int aid = Integer.parseInt(request.getParameter("aid"));
		System.out.println(username);
		
		AdminDao userdao = new AdminDao();
		userdao.updateUser(aid, username, password, name, email, phone, lend_num, max_num);
		response.sendRedirect("admin_user.jsp");
	}

}
