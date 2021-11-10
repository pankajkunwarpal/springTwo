package com.example.springTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class QueryPerson {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            System.out.println("\nGetting Persons from database....\n");
//            session.beginTransaction();
//
//            List<Person> person  = session.createQuery("from Person").getResultList();
//
//            for (Object p: person) {
//                System.out.println(p);
//            }
//
//            session.getTransaction().commit();
//
//
//            /*
//            Updating tabel values
//             */
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            int pid = 4;
//
//            Person p = session.get(Person.class, pid);
//            System.out.println("Updating Person.....");
//
//            p.setName("N Kumar");
//
//            session.getTransaction().commit();
//
//            System.out.println("Update Done.....");
//

            /*
            Selecting Person with WHERE condition
             */
//
//            System.out.println("Updating All Person Age.....");
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            System.out.println("Update All Person age");
//
//            session.createQuery("update Person set age = 36")
//                    .executeUpdate();
//
//            session.getTransaction().commit();
//
//            System.out.println("Update Done...");
//
//
//            /*
//            Deleting Person entity
//             */
//
//            System.out.println("Deleting Person.....");
//            session = factory.getCurrentSession();
//            int pid = 7;
//
//            session.beginTransaction();
//
//            Person p = session.get(Person.class, pid);
//            session.delete(p);
//
//            session.createQuery("delete from Person where id = 11")
//                            .executeUpdate();
//
//            session.getTransaction().commit();
//
//            System.out.println("Deleting Person Done....");


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            System.out.println("All Done");
            factory.close();

        }
    }
}
