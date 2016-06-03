package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.StudentDao;
import service.impl.StudentDaoImpl;
import utils.RandomNumberGenerator;

import com.opensymphony.xwork2.ModelDriven;

import entity.Student;

//学生Action类
public class StudentAction extends SuperAction implements ModelDriven<Student>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6208849000864186575L;
	private Student student =  new Student();
	
	
	//查询所有学生的动作
	public String query() {
		StudentDao sdao = new StudentDaoImpl();
		List<Student> list = sdao.queryAllStudents();
		//放进session中
		if(list!=null&&list.size()>0){
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	//删除学生动作
	public String delete() {
		StudentDao sdao = new StudentDaoImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudent(sid);//调用删除方法
		return "delete_success";
	}
	//添加学生动作
	public String add(){
		StudentDao sdao = new StudentDaoImpl();
		String sid = RandomNumberGenerator.generateNumber();
		student.setSid(sid);
		sdao.addStudent(student);//调用添加方法
		return "add_success";
	}
	//查询学生详细信息
	public String modify(){
		StudentDao sdao = new StudentDaoImpl();
		String sid = request.getParameter("sid");
		Student student = sdao.queryStudentBySid(sid);//调用查询方法
		//放进session中
		if(student!=null){
			session.setAttribute("modify_students", student);
		}
		return "modify_success";
	}
	//修改学生信息动作
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
