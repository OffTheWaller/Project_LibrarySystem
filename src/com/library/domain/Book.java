package com.library.domain;



/*
bidvarchar(32) NOT NULL
bnamevarchar(50) NOT NULL
bpricedouble NULL
bimagevarchar(200) NULL
bdatedatetime NULL
b_ishotint(11) NULL
bdescvarchar(255) NULL
cidvarchar(32) NULL
*/

public class Book {
	private String bid;
	private String bname;
	private double bprice;
	private String bimage;
	private String bdate;
	private int is_hot;
	private String bdesc;
	private String cid;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getBprice() {
		return bprice;
	}
	public void setBprice(double bprice) {
		this.bprice = bprice;
	}
	public String getBimage() {
		return bimage;
	}
	public void setBimage(String bimage) {
		this.bimage = bimage;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public String getBdesc() {
		return bdesc;
	}
	public void setBdesc(String bdesc) {
		this.bdesc = bdesc;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	
}
