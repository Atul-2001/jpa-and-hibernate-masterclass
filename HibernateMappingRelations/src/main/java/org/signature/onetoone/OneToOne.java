package org.signature.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.signature.onetoone.model.Laptop;
import org.signature.onetoone.model.Student;

public class OneToOne {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLap_id(101);
        laptop.setLap_name("Asus Vivobook S14");

        Student student = new Student();
        student.setRollNo(1);
        student.setName("Atul Suryavanshi");
        student.setPercentage(75);
        student.setLaptop(laptop);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(laptop);
        session.save(student);
        transaction.commit();

    }
}
