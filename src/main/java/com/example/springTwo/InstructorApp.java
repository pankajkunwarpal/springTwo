package com.example.springTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorApp {

    //Associated files Instructor and InstructorDetails.

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Instructor Object...");

            session.beginTransaction();

            deleteInstructorDetail(session);

            session.getTransaction().commit();

            System.out.println("Save Done!");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            System.out.println("All Done");
            factory.close();

        }
    }
    public static void addInstructor(Session session) {

        System.out.println("Creating Instructor and detail object....");
        Instructor tempIns = new Instructor("Bruce Wane", "Batman@email.com");
        InstructorDetail tempDe = new InstructorDetail("Being rich");
        System.out.println("Saving Person Object....");
        tempIns.setInstructorDetail(tempDe);

        session.save(tempIns);

    }

    public static void deleteInstructor(Session session) {
        int id = 1;

        Instructor tempIns = session.get(Instructor.class, id);
        System.out.println("Deleting Person Object....");
        if (tempIns != null) {
            System.out.println("Found: " + tempIns);
            System.out.println("Deleting: " + tempIns );

            // Also delete associated object because of cascade type all.
            session.delete(tempIns);
        }
    }

    public static void getInstructorDetail(Session session) {
        int id=2;
        System.out.println("Getting Instructor Details....");
        InstructorDetail tempD = session.get(InstructorDetail.class, id);

        System.out.println("Temp Instructor: " + tempD);
    }

    public static void deleteInstructorDetail(Session session) {
        int id =2;
        System.out.println("Getting Instructor details....");
        InstructorDetail tempD = session.get(InstructorDetail.class, id);
        System.out.println("Instructor Detail: " + tempD.toString());
        System.out.println("deleting....");
        session.delete(tempD);
        System.out.println("Deleted....");

    }
}
