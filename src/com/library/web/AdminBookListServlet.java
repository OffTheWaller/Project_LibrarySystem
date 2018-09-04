package com.library.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.Book;
import com.library.service.AdminBookService;

public class AdminBookListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//传递请求到service层
		AdminBookService service = new AdminBookService();
		List<Book> bookList = null;
		try {
			bookList = service.findAllBook();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//将productList放到request域
		request.setAttribute("bookList", bookList);
		
		request.getRequestDispatcher("/admin/book/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
