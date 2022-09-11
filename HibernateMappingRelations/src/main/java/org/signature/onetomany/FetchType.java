package org.signature.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.signature.onetomany.model.Laptop;
import org.signature.onetomany.model.Student;

public class FetchType {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg2.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
//        Lazy fetch if @OneToMany(mappedBy = "student")
//        Student student = session.get(Student.class, 1);
//        System.out.println(student);
//        for (Laptop laptop : student.getLaptop()) {
//            System.out.println(laptop);
//        }

//      Eager fetch if  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
        Student student = session.get(Student.class, 1);
        System.out.println(student);
        for (Laptop laptop : student.getLaptop()) {
            System.out.println(laptop);
        }
        transaction.commit();
    }
}
