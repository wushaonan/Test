package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.StudentDao;
import db.MyHibernateSessionFactory;
import entity.Student;

/**
 * 学生业务逻辑接口实现类
 * 
 * @author Sn_Wu
 *
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> queryAllStudents() {
		// 创建事物对象
		Transaction tx = null;
		String hql = "";
		List<Student> list = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Student";
			Query query = session.createQuery(hql);
			list = query.list();
			tx.commit();// 提交事务

		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}

		return list;
	}

	@Override
	public Student queryStudentBySid(String sid) {
		// 创建事物对象
		Transaction tx = null;
		Student student = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, sid);
			tx.commit();// 提交事务
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return null;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}

	}

	@Override
	public boolean addStudent(Student s) {
		// 创建事物对象
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();// 提交事务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		// 创建事物对象
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();// 提交事务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

	@Override
	public boolean deleteStudent(String sid) {
		// 创建事物对象
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			Student s = (Student) session.get(Student.class, sid);
			session.delete(s);
			tx.commit();// 提交事务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
			return false;
		} finally {
			if (tx != null) {
				tx = null;
			}
		}
	}

}
