package com.ys.po;

public class Orders {
	//订单ID
	private int id;
	//用户ID
	private int userId;
	//订单数量
	private String number;
	//和用户表构成一对一的关系，即一个订单只能由一个用户创建
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number
				+ ", user=" + user + "]";
	}

}
