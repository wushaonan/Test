package service;

import java.util.List;

import entity.Student;

/**
 * 学生的业务逻辑接口
 * @author Sn_Wu
 *
 */
public interface StudentDao {

	//查询所有学生
	public List<Student> queryAllStudents();
	//根据学生编号查询学生
	public Student queryStudentBySid(String sid);
	//添加学生
	public boolean addStudent(Student s);
	//修改学生
	public boolean updateStudent(Student s);
	//删除学生
	public boolean deleteStudent(String sid);
}
