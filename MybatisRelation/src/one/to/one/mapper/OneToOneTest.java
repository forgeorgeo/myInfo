package one.to.one.mapper;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.po.Orders;

public class OneToOneTest {
	//定义 SqlSession
	SqlSession session =null;
	
	@Before
	public void init(){
		//定义mybatis全局配置文件
		String resource = "mybatis-configuration.xml";
		//加载 mybatis 全局配置文件
		InputStream inputStream = OneToOneTest.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据 sqlSessionFactory 产生 session
		session = sessionFactory.openSession();
	}
	
	/**
	 * 方式一：嵌套结果
	 * select * from orders o,user u where o.user_id=u.id and o.id=#{id}
	 */
	//@Test
	public void testSelectOrderAndUserByOrderId(){
		String statement = "one.to.one.mapper.OrdersMapper.selectOrderAndUserByOrderID";
		//创建OrdersMapper对象，mybatis自动生成mapepr代理对象
		OrdersMapper orderMapper = session.getMapper(OrdersMapper.class);
		Orders order = orderMapper.selectOrderAndUserByOrderID(1);
		System.out.println(order);
		session.close();
	}
	
	/**
	 * 方式二：嵌套查询
	 * select * from order WHERE id=1;//得到user_id
	 * select * from user WHERE id=1   //1 是上一个查询得到的user_id的值
	 */
	@Test
	public void testgetOrderByOrderId(){
		String statement = "one.to.one.mapper.OrdersMapper.getOrderByOrderId";
		//创建OrdersMapper对象，mybatis自动生成mapepr代理对象
		OrdersMapper orderMapper = session.getMapper(OrdersMapper.class);
		Orders order = orderMapper.selectOrderAndUserByOrderID(1);
		System.out.println(order);
		System.out.println(order.getId()+"/"+order.getUser().getUsername());
		session.close();
	}
}
