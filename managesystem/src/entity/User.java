package entity;

//�û���
public class User {

	private String username;
	private String password;
	private int uid;
	
	public User(){}
	
	
	public User(String username, String password, int uid) {
		super();
		this.username = username;
		this.password = password;
		this.uid = uid;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
