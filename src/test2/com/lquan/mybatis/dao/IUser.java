package test2.com.lquan.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.lquan.test.models.User;

/**
 * 利用Mybatis接口注解进行处理
 * <p>Title:       IUser</p>
 * <p>Description: TODO</p>
 * <p>Created by  lquan on 2017年11月30日下午5:14:27 </p>
 *<p>@email:  </p>
 */
public interface IUser {

	@Select("select * from user where id= #{id}")
    public User getUserByID(int id);
	
}
