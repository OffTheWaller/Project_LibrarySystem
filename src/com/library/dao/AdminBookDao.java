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

	public Product findProductByPid(String pid) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?";
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		return product;
	}

//	public void updateProduct(Product product) throws SQLException {
//		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
//		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=?";
//		runner.update(sql,product.getPname(),product.getMarket_price(),
//				product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
//				product.getPdesc(),product.getPflag(),product.getCid(),product.getPid());
//	}

}
