package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.StudentDao;
import service.impl.StudentDaoImpl;
import utils.RandomNumberGenerator;

import com.chinapay.util.MD5Encryptor;
import com.opensymphony.xwork2.ModelDriven;

import entity.Student;

//ѧ��Action��
public class StudentAction extends SuperAction implements ModelDriven<Student>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6208849000864186575L;
	private Student student =  new Student();
	
	
	//��ѯ����ѧ���Ķ���
	public String query() {
		StudentDao sdao = new StudentDaoImpl();
		List<Student> list = sdao.queryAllStudents();
		//�Ž�session��
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	//ɾ��ѧ������
	public String delete() {
		StudentDao sdao = new StudentDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudent(sid);//����ɾ������
		return "delete_success";
	}
	//���ѧ������
	public String add(){
		StudentDao sdao = new StudentDaoImpl();
		String sid = RandomNumberGenerator.generateNumber();
		student.setSid(sid);
		String psw = student.getPsw();
		String md5Sign = MD5Encryptor.getMD5Encrypt(psw.toString());
		student.setPsw(md5Sign);
		sdao.addStudent(student);//������ӷ���
		return "add_success";
	}
	//��ѯѧ����ϸ��Ϣ
	public String modify(){
		StudentDao sdao = new StudentDaoImpl();
		String sid = request.getParameter("sid");
		Student student = sdao.queryStudentBySid(sid);//���ò�ѯ����
		//�Ž�session��
		if(student!=null){
			session.setAttribute("modify_students", student);
		}
		return "modify_success";
	}
	//�޸�ѧ����Ϣ����
	public String save(){
		StudentDao sdao = new StudentDaoImpl();
		sdao.updateStudent(student);
		return "save_success";
	}
	public static void main(String[] args) throws ParseException {
		String dateString = "2016-4-16";  
		try  
		{  
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		   Date date = sdf.parse(dateString);
		   System.out.println(date);
		}  
		catch (ParseException e)  
		{  
		    System.out.println(e.getMessage());  
		} 

	}
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return this.student;
	}
}
