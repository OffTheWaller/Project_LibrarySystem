package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.library.domain.Category;
import com.library.domain.Product;
import com.library.domain.Book;
import com.library.utils.DataSourceUtils;

public class AdminBookDao {

	public List<Book> findAllBook() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from book";
		List<Book> bookList = runner.query(sql, new BeanListHandler<Book>(Book.class));
		return bookList;
	}

	public List<Category> findAllCategory() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		List<Category> categoryList = runner.query(sql, new BeanListHandler<Category>(Category.class));
		return categoryList;
	}

	public void addBook(Book book) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into book values(?,?,?,?,?,?,?,?)";
		runner.update(sql, book.getBid(),book.getBname(),book.getBprice(),book.getBimage(),book.getBdate(),book.getIs_hot(),book.getBdesc(),book.getCid());
		
	}

	public void delBookByBid(String bid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from book where bid=?";
		runner.update(sql, bid);
		
	}

	public Book findBookByBid(String bid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from book where bid=?";
		Book book = runner.query(sql, new BeanHandler<Book>(Book.class), bid);
		return book;
	}

	public void updateBook(Book book) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update book set bname=?,bprice=?,bimage=?,bdate=?,is_hot=?,bdesc=?,cid=? where bid=?";
		runner.update(sql,book.getBname(),book.getBprice(),
				book.getBimage(),book.getBdate(),book.getIs_hot(),
				book.getBdesc(),book.getCid(),book.getBid());
	}

}
