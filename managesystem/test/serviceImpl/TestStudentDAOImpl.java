package serviceImpl;

import java.util.List;

import org.junit.Test;

import service.StudentDao;
import service.impl.StudentDaoImpl;
import entity.Student;

public class TestStudentDAOImpl {

	@Test
	public void testQueryAllStudent(){
		StudentDao sdao = new StudentDaoImpl();
		List<Student> list = sdao.queryAllStudents();
	    for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
