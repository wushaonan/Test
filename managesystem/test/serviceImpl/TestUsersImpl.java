package serviceImpl;

import junit.framework.Assert;

import org.junit.Test;

import service.UsersDao;
import service.impl.UsersDaoImpl;
import entity.User;

public class TestUsersImpl {

	@Test
	public void testUsersLogin(){
		User u = new User("wushaonan","123456",1);
		UsersDao uDao = new UsersDaoImpl();
		Assert.assertEquals(true, uDao.userLogin(u));
	}
}
