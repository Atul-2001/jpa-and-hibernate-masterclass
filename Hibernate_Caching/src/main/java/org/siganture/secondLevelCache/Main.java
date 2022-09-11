package org.siganture.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.siganture.secondLevelCache.model.Student;

public class Main {
    public static void main(String[] args) {
//      Example of second level cache
        Configuration configuration = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        System.out.println("--------------------Session 1---------------------");
        Student student = session.get(Student.class, 1);
        System.out.println(student);
        Student student2 = session.get(Student.class, 2);
        System.out.println(student2);
        Student student1 = session.get(Student.class, 1);
        System.out.println(student1);
        session.getTransaction().commit();
        session.close();

        System.out.println("---------------Session 2-----------------");
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        student = session1.get(Student.class, 1);
        System.out.println(student);
        student2 = session1.get(Student.class, 2);
        System.out.println(student2);
        student1 = session1.get(Student.class, 1);
        System.out.println(student1);
        session1.getTransaction().commit();
        session1.close();
        sessionFactory.close();
        serviceRegistry.close();
    }
}
