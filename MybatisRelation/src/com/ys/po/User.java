package com.ys.po;

import java.util.List;

public class User {
	//用户ID
	private int id;
	//用户姓名
	private String username;
	//用户性别
	private String sex;
	//一个用户能创建多个订单，用户和订单构成一对多的关系
	public List<Orders> orders;
	//一个用户能被分配多中角色
	public List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex
				+ "]";
	}
}
