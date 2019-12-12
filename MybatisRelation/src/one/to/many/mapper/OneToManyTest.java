package one.to.many.mapper;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.po.Orders;
import com.ys.po.User;

public class OneToManyTest {
	//定义 SqlSession
	SqlSession session =null;
	
	@Before
	public void init(){
		//定义mybatis全局配置文件
		String resource = "mybatis-configuration.xml";
		//加载 mybatis 全局配置文件
		InputStream inputStream = OneToManyTest.class.getClassLoader()
									.getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据 sqlSessionFactory 产生 session
		session = sessionFactory.openSession();
	}
	
	@Test
	public void testSelectOrderAndUserByOrderId(){
		String statement = "one.to.many.mapper.UserMapper.selectUserAndOrdersByUserId";
		//创建OrdersMapper对象，mybatis自动生成mapepr代理对象
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.selectUserAndOrdersByUserId(1);
		System.out.println(user.getOrders().size());
		session.close();
	}
}
