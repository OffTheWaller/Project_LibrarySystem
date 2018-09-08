package com.library.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.Book;
import com.library.domain.Category;
import com.library.domain.Product;
import com.library.service.AdminBookService;

public class AdminUpdateBookUIServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获得要查询Book的bid
		String bid = request.getParameter("bid");
		//传递bid查询商品信息
		AdminBookService service = new AdminBookService();
		Book book = null;
		try {
			book = service.findBookByBid(bid);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//获得所有图书的类别数据
		List<Category> categoryList = null;
		try {
			categoryList = service.findAllCategory();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("categoryList", categoryList);
		request.setAttribute("book", book);

		request.getRequestDispatcher("/admin/book/edit.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}