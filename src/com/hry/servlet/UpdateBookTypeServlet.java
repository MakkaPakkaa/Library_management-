package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hry.dao.TypeDao;


/**
 * Servlet implementation class UpdateBookTypeServlet
 */
@WebServlet("/UpdateBookTypeServlet")
public class UpdateBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateBookTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改图书类型信息
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		//Integer 类：parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析
		//分类的id
		int tid = Integer.parseInt(request.getParameter("tid"));
		TypeDao typedao = new TypeDao();
		typedao.updateTypeBook(tid,name);
		response.sendRedirect("admin_booktype.jsp");
	}

}
