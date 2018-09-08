package com.library.service;

import java.sql.SQLException;
import java.util.List;

import com.library.dao.AdminBookDao;
import com.library.domain.Book;
import com.library.domain.Category;
import com.library.domain.Product;

public class AdminBookService {
	
	//查询所有图书
	public List<Book> findAllBook() throws SQLException {
		//因为没有复杂业务 直接传递请求到dao层
		AdminBookDao dao = new AdminBookDao();
		return dao.findAllBook();
	}

	//获得所有的类别
	public List<Category> findAllCategory() throws SQLException {
		AdminBookDao dao = new AdminBookDao();
		return dao.findAllCategory();
	}

	//添加数据
	public void addBook(Book book) throws SQLException {
		AdminBookDao dao = new AdminBookDao();
		dao.addBook(book);
	}

	//根据bid删除图书
	public void delBookByBid(String bid) throws SQLException {
		AdminBookDao dao = new AdminBookDao();
		dao.delBookByBid(bid);
	}

	
	//根据bid查询图书对象
	public Book findBookByBid(String bid) throws SQLException {
		AdminBookDao dao = new AdminBookDao();
		return dao.findBookByBid(bid);
	}

	
	//更新商品
	public void updateBook(Book book) throws SQLException {
		AdminBookDao dao = new AdminBookDao();
		dao.updateBook(book);
	}

}
