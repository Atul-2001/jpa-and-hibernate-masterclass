package org.signature;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.service.ServiceRegistry;
import org.signature.model.Student;

import java.util.List;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
            configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:h2:file:~/IdeaProjects/LearnHQL/hqlDB");
            configuration.setProperty("hibernate.hbm2ddl.auto", "update");
            configuration.setProperty("hibernate.show_sql", "true");
            configuration.addAnnotatedClass(Student.class);

            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(registry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        Session session = getSession();

        session.beginTransaction();

        /*List<Student> students = query.list();
        for (Student student : students) {
            System.out.println(student);
        }*/

        /*Query query = session.createQuery("from Student where rollNo = 15");
        Student student = (Student) query.uniqueResult();
        System.out.println(student);*/

        /*Query query = session.createQuery("select rollNo, name, marks from Student where rollNo = 15");
        Object[] student = (Object[]) query.uniqueResult();
        System.out.println(student[0] + " : " + student[1] + " : " + student[2]);*/

        /*Query query = session.createQuery("select rollNo, name, marks from Student");
        List<Object[]> students = (List<Object[]>) query.list();
        for (Object[] obj : students) {
            System.out.println(obj[0] + " : " + obj[1] + " : " + obj[2]);
        }*/

        /*Query query = session.createQuery("select sum(marks) from Student");
        Long marks = (Long) query.uniqueResult();
        System.out.println("Marks : " + marks);*/

/*//        Query query = session.createQuery("from Student where rollNo = :roll");
        Query query = session.createQuery("from Student s where s.rollNo = :roll");
        query.setParameter("roll", 20);
        Student student = (Student) query.uniqueResult();
        System.out.println(student);*/

        /*NativeQuery query = session.createSQLQuery("select * from Student where marks > 60");
        query.addEntity(Student.class);
        List<Student> students = (List<Student>) query.list();

        for (Student student : students) {
            System.out.println(student);
        }*/

        // Native Queries....
        NativeQuery query = session.createSQLQuery("select name,marks from Student where marks > 60");
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students = query.list();

        for (Object obj : students) {
            Map<String, Object> result = (Map<String, Object>) obj;
            System.out.println(result.get("MARKS") + " : " + result.get("NAME"));
        }

        session.getTransaction().commit();
    }
}