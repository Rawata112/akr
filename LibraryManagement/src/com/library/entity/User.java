package com.library.entity;

import java.sql.Date;

public class User {
	private String id;
	private String password;
	private String first;
	private String last;
	private int type;
	private Date joining;
	public Date getJoining() {
		return joining;
	}
	public void setJoining(Date joining) {
		this.joining = joining;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
