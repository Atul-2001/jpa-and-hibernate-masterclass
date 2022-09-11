package org.signature.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.signature.manytoone.model.Laptop;
import org.signature.manytoone.model.Student;

public class ManyToOne {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop();
        laptop1.setLap_id(101);
        laptop1.setLap_name("Asus Vivobook S14");

        Laptop laptop2 = new Laptop();
        laptop2.setLap_id(102);
        laptop2.setLap_name("Asus Vivobook S15");

        Laptop laptop3 = new Laptop();
        laptop3.setLap_id(103);
        laptop3.setLap_name("Dell XPS 13");

        Student student = new Student();
        student.setRollNo(1);
        student.setName("Atul Suryavanshi");
        student.setPercentage(75);
        student.getLaptop().add(laptop1);
        student.getLaptop().add(laptop2);
        laptop1.setStudent(student);
        laptop2.setStudent(student);

        Student student2 = new Student();
        student2.setRollNo(2);
        student2.setName("Rishu Suryavanshi");
        student2.setPercentage(85);
        student2.getLaptop().add(laptop3);
        laptop3.setStudent(student2);

        Configuration configuration = new Configuration().configure("hibernate.cfg3.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.save(laptop1);
        session.save(laptop2);
        session.save(laptop3);
        session.save(student);
        session.save(student2);
        transaction.commit();
    }
}
