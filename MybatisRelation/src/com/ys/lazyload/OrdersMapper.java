package com.ys.lazyload;

import java.util.List;

import com.ys.lazyload.Orders;
import com.ys.lazyload.User;

public interface OrdersMapper {
	/**
	 * select * from order //得到user_id
	 * select * from user WHERE id=1   //1 是上一个查询得到的user_id的值
	 * @param userID
	 * @return
	 */
	//得到订单信息(包含user_id)
	public List<Orders> getOrderByOrderId();
	//根据用户ID查询用户信息
	public User getUserByUserId(int userID);

}
