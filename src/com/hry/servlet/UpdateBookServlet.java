package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hry.dao.BookDao;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//修改图书信息
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		response.setContentType("/texthtml;charset= UTF-8");
		
		String card = request.getParameter("card");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String autho = request.getParameter("autho");
		String press = request.getParameter("press");
		//Integer 类：parseInt() 方法用于将字符串参数作为有符号的十进制整数进行解析
		int num = Integer.parseInt(request.getParameter("num"));
		int bid = Integer.parseInt(request.getParameter("updatebid"));
		System.out.println(bid);
		BookDao bookdao = new BookDao();
		bookdao.updateBook(bid, card, name, type, autho, press, num);
	
		response.sendRedirect("admin_book.jsp");
	}

}
