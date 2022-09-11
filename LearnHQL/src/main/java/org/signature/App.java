package org.signature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.signature.model.Laptop;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:file:~/IdeaProjects/LearnHQL/hqlDB");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.connection.autocommit", "true");
        configuration.addAnnotatedClass(Laptop.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory factory = configuration.buildSessionFactory(registry);
        Session session = factory.openSession();

        session.beginTransaction();
        Random random = new Random();
        for(int i = 1; i < 10; i++) {
            Laptop laptop = new Laptop();
            laptop.setLname("Laptop " + i);
            laptop.setPrice(random.nextInt(100000));
            session.save(laptop);
        }
        session.getTransaction().commit();
    }
}
