package com.library.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.Category;
import com.library.service.AdminBookService;

public class AdminAddBookUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获得所有的图书的类别数据
		AdminBookService service = new AdminBookService();
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("categoryList", categoryList);
		
		request.getRequestDispatcher("/admin/book/add.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
