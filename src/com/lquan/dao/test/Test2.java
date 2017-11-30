package com.lquan.dao.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lquan.test.models.User;

import test2.com.lquan.mybatis.dao.IUser;

/**
 * 
 * <p>Title:       Test1</p>
 * <p>Description: 测试mybatis模块</p>
 * <p>Created by  lquan on 2017年11月30日下午4:15:01 </p>
 *<p>@email:  </p>
 */
public class Test2 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure2.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().addMapper(IUser.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		IUser iuser = session.getMapper(IUser.class);
        User u = iuser.getUserByID(1);
		System.out.println("Mybatis接口注解:"+u.toString());
		

	}

}
