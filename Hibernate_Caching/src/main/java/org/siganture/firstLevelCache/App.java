package org.siganture.firstLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.siganture.firstLevelCache.model.Student;

public class App {
    public static void main(String[] args) {
        /*Student student = new Student();
        student.setRoll_no(1);
        student.setName("Atul Suryavanshi");
        student.setPercentage(75);

        Student student1 = new Student();
        student1.setRoll_no(2);
        student1.setName("Rishu Suryavanshi");
        student1.setPercentage(85);

        Student student2 = new Student();
        student2.setRoll_no(3);
        student2.setName("Ashutosh Suryavanshi");
        student2.setPercentage(90);*/

//      Example of 1st level cache
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
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
    }
}
