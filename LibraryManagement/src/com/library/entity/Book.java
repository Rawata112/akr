package com.library.entity;

public class Book {
	
	private String writer;
	private String publisher;
	private int bookId;
	private String bookName;
	private int price;
	private int available;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [writer=" + writer + ", publisher=" + publisher + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", price=" + price + ", available=" + available + "]";
	}
	
	
}
