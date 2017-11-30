package test2.com.lquan.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lquan.test.models.User;

/**
 * Mybatis增删改查（CURD
 * <p>Title:       IUser</p>
 * <p>Description: TODO</p>
 * <p>Created by  lquan on 2017年11月30日下午5:14:27 </p>
 *<p>@email:  </p>
 */
public interface IUser3 {

	//@Select("select * from user where id= #{id}")
    //public User getUserByID(int id);
	
	public List<User> getUserList();

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int id);
    
    
}
