package com.lquan.dao.test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lquan.test.models.User;

/**
 * 
 * <p>Title:       Test1</p>
 * <p>Description: 主要测试mybatis的传入参数问题map类型，list类型数据</p>
 * <p>Created by  lquan on 2017年11月30日下午4:15:01 </p>
 *<p>@email:  </p>
 */
public class Test5 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure5.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}
	
	/**
	 * 测试传入参数是map类型
	 */
	@Test
	public  void testparMap() {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, String> map = new HashMap<>();
		//map.put("id", "4");
		//map.put("dept", "Tech");
		//map.put("phone", "1201");
		map.put("name", "Google");
		List<User> u = session.selectList("com.lquan.test.userMapper.getUserList",map);
		System.out.println("数量："+u.size()+"：参数类型map"+u.toString());
		

	}
	
	/**
	 * 传入参数是list类型
	 */
	@Test
	public  void testparList() {
	//public static void main(String[] args) {
		
		SqlSession session = sqlSessionFactory.openSession();
		List<Integer> listx = new ArrayList<>();
		listx.add(1);
		listx.add(2);
		listx.add(3);
		List<User> u = session.selectList("com.lquan.test.userMapper.getUserListparamList",listx);
		System.out.println("数量xx："+u.size()+"：参数类型map"+u.toString());
	}
	

	/**
	 * 传入参数是数组类型
	 */
	@Test
	public  void testparArray() {
		
		SqlSession session = sqlSessionFactory.openSession();
		int[] id = {1,2,4};
		List<User> u = session.selectList("com.lquan.test.userMapper.getUserListparamArray",id);
		System.out.println("数组参数-数量："+u.size()+"：参数类型map"+u.toString());
	}
}
