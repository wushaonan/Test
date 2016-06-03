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
		// �������ö���
		Configuration configuration = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// ������ע��ķ��񴴽�sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//����Session����
		Session session = sessionFactory.getCurrentSession();
		//����SchemaExport����
		SchemaExport schemaExport = new SchemaExport(configuration);	
		schemaExport.create(true, true);	

	}
	//��Ӳ�������
	@Test
	public void testSaveStudents(){
		// �������ö���
		Configuration configuration = new Configuration().configure();
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		// ������ע��ķ��񴴽�sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		//����Session����
		Session session = sessionFactory.getCurrentSession();
		//�����������
		Transaction tx = session.beginTransaction();
//		Student s1 = new Student("S0000001","������","��",new Date(),"�䵱ɽ");
//		Student s2 = new Student("S0000002","����","��",new Date(),"���ԭ");
//		Student s3 = new Student("S0000003","����","Ů",new Date(),"�һ���");
		User user = new User("wushaonan","123456",0001);
		session.save(user);
//		session.save(s2);
//		session.save(s3);
		tx.commit();
		sessionFactory.close();
		
	}
}
