package com.lquan.dao.test;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import javax.print.DocFlavor.STRING;

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
 * <p>Description: 测试mybatis多参数情况下的模块</p>
 * <p>Created by  lquan on 2017年11月30日下午4:15:01 </p>
 *<p>@email:  </p>
 */
public class Test4_2 {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configure4_2.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		User userx = new User();
		userx.setName("lq");
		SqlSession session = sqlSessionFactory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "Google");
		map.put("dept","Tech1");
		
		List<User> user = session.selectList("com.lquan.test.userMapper.getUserList",map); 
	     System.out.println("用户："+user.toString());
//                 List<Post> posts = user.getPosts();  
//                 for(User p : user) {
//                     System.out.println("post:"+p.toString()); 
//                 }
	}

}
