package action;

import service.StudentDao;
import service.UsersDao;
import service.impl.StudentDaoImpl;
import service.impl.UsersDaoImpl;

import com.chinapay.util.MD5Encryptor;
import com.opensymphony.xwork2.ModelDriven;

import entity.Student;
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
		StudentDao sdao = new StudentDaoImpl();
		//ѧ����¼
		String sname = user.getUsername();
		String psw = user.getPassword();
		//����MD5����
		String md5Sign = MD5Encryptor.getMD5Encrypt(psw.toString());
		Student student = new Student();
		student.setSname(sname);
		student.setPsw(md5Sign);
		if(uDao.userLogin(user)){
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}else if(sdao.studentLogin(student)){
			session.setAttribute("loginUserName", student.getSname());
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
