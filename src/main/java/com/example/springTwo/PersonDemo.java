package com.example.springTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.util.Date;


public class PersonDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Person Object...");
            Person tempPerson1 = new Person("Q Kumar", "Qall@email.com", 32);
            Person tempPerson2 = new Person("S Kumar", "Sall@email.com", 33);
            Person tempPerson3 = new Person("W Kumar", "Wall@email.com", 34);
            Person tempPerson4 = new Person("T Kumar", "Tall@email.com", 35);

            session.beginTransaction();

            System.out.println("Saving Person Object....");
            session.save(tempPerson1);
            session.save(tempPerson2);
            session.save(tempPerson3);
            session.save(tempPerson4);

            session.getTransaction().commit();

            System.out.println("Save Done!");

            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Retrieving Data");

            Person p1 = session.get(Person.class, tempPerson1.getId());
            Person p2 = session.get(Person.class, tempPerson2.getId());
            Person p3 = session.get(Person.class, tempPerson3.getId());
            Person p4 = session.get(Person.class, tempPerson4.getId());

            System.out.println(" Person "  + p1);
            System.out.println(" Person "  + p2);
            System.out.println(" Person "  + p3);
            System.out.println(" Person "  + p4);

            session.getTransaction().commit();

            System.out.println("Retrieve Done!!!");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            System.out.println("All Done");
            factory.close();

        }
    }
}
