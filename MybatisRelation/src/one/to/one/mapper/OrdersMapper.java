package one.to.one.mapper;

import com.ys.po.Orders;
import com.ys.po.User;

public interface OrdersMapper {
	/**
	 * 方式一：嵌套结果
	 * select * from orders o,user u where o.user_id=u.id and o.id=#{id}
	 * @param orderId
	 * @return
	 */
	//根据订单ID查询订单和用户信息
	public Orders selectOrderAndUserByOrderID(int orderId);
	
	/**
	 * 方式二：嵌套查询
	 * select * from order WHERE id=1;//得到user_id
     * select * from user WHERE id=1   //1 是上一个查询得到的user_id的值
	 * @param userID
	 * @return
	 */
	//根据订单ID得到订单信息(包含user_id)
	public Orders getOrderByOrderId(int orderId);
	//根据用户ID查询用户信息
	public User getUserByUserId(int userID);

}
