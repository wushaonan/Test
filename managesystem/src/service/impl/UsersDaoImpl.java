package service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.UsersDao;
import db.MyHibernateSessionFactory;
import entity.User;

public class UsersDaoImpl implements UsersDao
{

	@Override
	public boolean userLogin(User user) {
		//创建事物对象
		Transaction tx = null;
		String hql="";
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from User where username=? and password=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				User u = (User)list.get(i);
			}
			tx.commit();//提交事务
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
