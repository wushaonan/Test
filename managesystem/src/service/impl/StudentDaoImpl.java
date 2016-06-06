package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.StudentDao;
import db.MyHibernateSessionFactory;
import entity.Student;
import entity.User;

/**
 * ѧ��ҵ���߼��ӿ�ʵ����
 * 
 * @author Sn_Wu
 *
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> queryAllStudents() {
		// �����������
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
			tx.commit();// �ύ����

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
		// �����������
		Transaction tx = null;
		Student student = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			student = (Student) session.get(Student.class, sid);
			tx.commit();// �ύ����
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
		// �����������
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
			tx.commit();// �ύ����
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
		// �����������
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();// �ύ����
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
		// �����������
		Transaction tx = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory()
					.getCurrentSession();
			tx = session.beginTransaction();
			Student s = (Student) session.get(Student.class, sid);
			session.delete(s);
			tx.commit();// �ύ����
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
	public boolean studentLogin(Student s) {
		//�����������
				Transaction tx = null;
				String hql="";
				try {
					Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
					tx = session.beginTransaction();
					hql = "from Student where sname=? and psw=?";
					Query query = session.createQuery(hql);
					query.setParameter(0, s.getSname());
					query.setParameter(1, s.getPsw());
					List list = query.list();
					for (int i = 0; i < list.size(); i++) {
						Student u = (Student)list.get(i);
					}
					tx.commit();//�ύ����
					if(list.size()>0){
						return true;
					}else{
						return false;
					}
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}finally{
					if(tx!=null){
						tx=null;
					}
				}
				
			}

}
