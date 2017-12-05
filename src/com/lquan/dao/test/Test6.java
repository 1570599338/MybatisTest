package com.lquan.dao.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lquan.test.models.User;

/**
 * 
 * <p>Title:       Test1</p>
 * <p>Description: 测试mybatis执行存储过程</p>
 * <p>Created by  lquan on 2017年11月30日下午4:15:01 </p>
 *<p>@email:  </p>
 */
public class Test6 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure6.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		//User u = session.selectOne("com.yiibai.mybatis.models.UserMapper.GetUserByID",1);
		//System.out.println(u.toString());
		
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("sexid", 1);
        parameterMap.put("usercount", -1);
       Object a = session.selectOne("com.yiibai.mybatis.models.UserMapper.getUserCount", parameterMap);
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
        session.close();
		

	}

}
