package entity;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestStudent {

	@Test
	public void testSchemaExport() {
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// 根据所注册的服务创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//创建Session对象；
		Session session = sessionFactory.getCurrentSession();
		//创建SchemaExport对象
		SchemaExport schemaExport = new SchemaExport(configuration);	
		schemaExport.create(true, true);	

	}
	//添加测试数据
	@Test
	public void testSaveStudents(){
		// 创建配置对象
		Configuration configuration = new Configuration().configure();
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// 根据所注册的服务创建sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//创建Session对象；
		Session session = sessionFactory.getCurrentSession();
		//创建事物对象
		Transaction tx = session.beginTransaction();
//		Student s1 = new Student("S0000001","张三丰","男",new Date(),"武当山");
//		Student s2 = new Student("S0000002","郭靖","男",new Date(),"大草原");
//		Student s3 = new Student("S0000003","黄蓉","女",new Date(),"桃花岛");
		User user = new User("wushaonan","123456",0001);
		session.save(user);
//		session.save(s2);
//		session.save(s3);
		tx.commit();
		sessionFactory.close();
		
	}
}
