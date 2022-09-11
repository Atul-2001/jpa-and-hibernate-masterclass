package org.signature;

import org.signature.model.Laptop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("jpaDB");
        EntityManager manager = managerFactory.createEntityManager();

        manager.getTransaction().begin();
        /*Random random = new Random();
        for (int i = 1; i < 10; i++) {
            Laptop laptop = new Laptop();
            laptop.setLid(i);
            laptop.setL_name("Lap " + i);
            laptop.setPrice(random.nextInt(100000));
            manager.persist(laptop);
        }*/

        Laptop laptop = manager.find(Laptop.class, 6);
        System.out.println(laptop);
        manager.getTransaction().commit();
    }
}
