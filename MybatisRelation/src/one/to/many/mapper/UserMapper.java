package one.to.many.mapper;

import com.ys.po.User;

public interface UserMapper {
	//根据用户id查询用户信息，以及用户下面的所有订单信息
	public User selectUserAndOrdersByUserId(int UserId);

}
