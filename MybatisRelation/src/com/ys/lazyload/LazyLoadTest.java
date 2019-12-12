package com.ys.lazyload;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.ys.lazyload.User;

public class LazyLoadTest {
	//定义 SqlSession
	SqlSession session =null;
	
	@Before
	public void init(){
		//定义mybatis全局配置文件
		String resource = "mybatis-configuration.xml";
		//加载 mybatis 全局配置文件
		InputStream inputStream = LazyLoadTest.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据 sqlSessionFactory 产生 session
		session = sessionFactory.openSession();
	}
	@Test
	public void testLazy(){
		String statement = "com.ys.lazyload.OrdersMapper.getOrderByOrderId";
		//创建OrdersMapper对象，mybatis自动生成mapepr代理对象
		OrdersMapper orderMapper = session.getMapper(OrdersMapper.class);
		List<Orders> orders = orderMapper.getOrderByOrderId();
		System.out.println("orders="+orders);
		for(Orders order : orders){
			System.out.println("order.getUser="+order.getUser());
		}
		session.close();
	}

}
