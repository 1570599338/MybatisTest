package com.lquan.dao.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lquan.test.models.Post;
import com.lquan.test.models.ReadUser;
import com.lquan.test.models.User;

/**
 * 
 * <p>Title:       Test1</p>
 * <p>Description: 测试mybatis模块</p>
 * <p>Created by  lquan on 2017年11月30日下午4:15:01 </p>
 *<p>@email:  </p>
 */
public class Test4 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure4.xml");
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
		ReadUser user = session.selectOne("com.yiibai.userMaper.getReadUser", 1); 
	     System.out.println("用户："+user.toString());
                 List<Post> posts = user.getPosts();  
                 for(Post p : posts) {
                     System.out.println("post:"+p.toString()); 
                 }
	}

}
