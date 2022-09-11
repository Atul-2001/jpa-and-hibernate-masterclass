package org.siganture.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.siganture.secondLevelCache.model.Student;

public class MainQ {
    public static void main(String[] args) {
        //      Example of second level cache
        Configuration configuration = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        System.out.println("--------------------Session 1---------------------");
        Query query = session.createQuery("FROM Student WHERE id=1");
        query.setCacheable(true);
        Student student = (Student) query.uniqueResult();
        System.out.println(student);

        query = session.createQuery("FROM Student WHERE id=2");
        query.setCacheable(true);
        Student student2 = (Student) query.uniqueResult();
        System.out.println(student2);

        query = session.createQuery("FROM Student WHERE id=1");
        query.setCacheable(true);
        Student student1 = (Student) query.uniqueResult();
        System.out.println(student1);

        session.getTransaction().commit();
        session.close();

        System.out.println("---------------Session 2-----------------");
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Query query1 = session1.createQuery("FROM Student WHERE id=1");
        query1.setCacheable(true);
        student = (Student) query1.uniqueResult();
        System.out.println(student);

        query1 = session1.createQuery("FROM Student WHERE id=2");
        query1.setCacheable(true);
        student2 = (Student) query1.uniqueResult();
        System.out.println(student2);

        query1 = session1.createQuery("FROM Student WHERE id=1");
        query1.setCacheable(true);
        student1 = (Student) query1.uniqueResult();
        System.out.println(student1);

        session1.getTransaction().commit();
        session1.close();
        sessionFactory.close();
        serviceRegistry.close();
    }
}
