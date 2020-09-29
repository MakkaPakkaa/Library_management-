package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hry.dao.BookDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//删除图书信息
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		//Integer 类：parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析
		int bid = Integer.parseInt(request.getParameter("bid"));
		BookDao bookdao = new BookDao();
		bookdao.deleteBook(bid);
		response.sendRedirect("admin_book.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
