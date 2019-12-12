package many.to.many.mapper;

import java.util.List;

import com.ys.po.User;

public interface UserMapper {
	
	//给定一个角色id，要得到具有这个角色的所有用户信息
	public List<User> getUserByRoleId(int roleId);

}
