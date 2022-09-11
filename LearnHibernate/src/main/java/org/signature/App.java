package org.signature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.signature.model.Name;
import org.signature.model.Student;

public class App {
    public static void main(String[] args) {
        Name stu_name = new Name();
        stu_name.setFirst_name("Atul");
        stu_name.setMiddle_name("Singh");
        stu_name.setLast_name("Suryavanshi");

        Student student = new Student();
        student.setId(9719001);
        student.setName(stu_name);
        student.setRoll_no(1);
        student.setStandard(12);
        student.setFather_name("Tej Pratap Singh");
        student.setMother_name("Asha Singh");

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(student);
//        student = session.get(Student.class, 9719001);
        transaction.commit();

        System.out.println(student);
    }
}
