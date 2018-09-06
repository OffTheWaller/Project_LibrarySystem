package com.library.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.library.domain.Book;
import com.library.domain.Product;
import com.library.service.AdminBookService;

public class AdminAddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//使服务器获取中文参数
		request.setCharacterEncoding("UTF-8");
		
		//1、获取数据(使用BeanUtils获取整个表单的数据，要检查一下表单中的name和实体中的字段是否名字一样)
		Map<String, String[]> properties = request.getParameterMap();
		//2、封装数据
		Book book = new Book();
		try {
			BeanUtils.populate(book, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//此位置Product已经封装完毕----将表单的数据封装完毕
		//手动设置表单中没有数据
		//1）、private String pid;
		book.setBid(UUID.randomUUID().toString());
		//2）、private String pimage;
		book.setBimage("books/1.jpg");
		//3）、private String pdate;//上架日期
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String bdate = format.format(new Date());
		book.setBdate(bdate);
		
		
		//3、传递数据给service层
		AdminBookService service = new AdminBookService();
		try {
			service.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/adminBookList");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}