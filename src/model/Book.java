package model;

public class Book {
	private String bookname;
	private String author;
	private float price;
	
	//构造器
	public Book(String bookname, String author, float price) {
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}
	
	//获取各个成员变量的值
	public String getBookname() {
		return bookname;
	}
	public String getAuthor() {
		return author;
	}
	public float getPrice() {
		return price;
	}
	
	//重置各个字段的值
	public void setBook(String bookname, String author, float price) {
		this.bookname = bookname;
		this.author = author;
		this.price = price;
	}
	
	
	
	
}
