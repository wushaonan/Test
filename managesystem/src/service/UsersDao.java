package service;

import entity.User;

//用户业务逻辑接口
public interface UsersDao {

	//用户登录方法
	public boolean userLogin(User user);
}
