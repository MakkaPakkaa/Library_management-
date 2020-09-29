package com.hry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hry.dao.TypeDao;

/**
 * Servlet implementation class AddBookTypeServlet
 */
@WebServlet("/AddBookTypeServlet")
public class AddBookTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码类型
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//获取图书分类的名称
		String name = request.getParameter("name");
		TypeDao typedao = new TypeDao();
		//调用函数存入图书分类信息
		typedao.addBookType(name);
		response.sendRedirect("admin_booktype.jsp");
	}

}
