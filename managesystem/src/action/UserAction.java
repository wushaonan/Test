package action;

import service.UsersDao;
import service.impl.UsersDaoImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class UserAction extends SuperAction implements ModelDriven<User>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7508270933793720483L;
    private User user = new User();
    
    //�û���¼����
    public String  login() {
		UsersDao  uDao = new UsersDaoImpl();
		if(uDao.userLogin(user)){
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else{
			return "login_failure";
		}
		
	}
    //�û��˳�
    public String logout(){
    	return "logout_success";
    }
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
