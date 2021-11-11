package com.example.springTwo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class InstructorApp {

    //Associated files Instructor and InstructorDetails and Course.

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new Instructor Object...");

            session.beginTransaction();

            addCourseToStudent(session);

            session.getTransaction().commit();

            System.out.println("Save Done!");

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            System.out.println("All Done");
            session.close();
            factory.close();

        }
    }
    public static void addInstructor(Session session) {

        System.out.println("Creating Instructor and detail object....");
        Instructor tempIns = new Instructor("Barry Allen", "Flash@email.com");
        InstructorDetail tempDe = new InstructorDetail("Running");
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
        int id = 4;
        System.out.println("Getting Instructor details....");
        InstructorDetail tempD = session.get(InstructorDetail.class, id);
        System.out.println("Instructor Detail: " + tempD.toString());
        System.out.println("deleting....");
        session.delete(tempD);
        System.out.println("Deleted....");

    }

    public static void createCourse(Session session) {
        System.out.println("Creating a course...");
        int id = 4;
        Instructor tempIns = session.get(Instructor.class, id);
        System.out.println("Person: " + tempIns);

        Course c1 = new Course("Be rich");
        Course c2 = new Course("Different Fighting styles");

        tempIns.add(c1);
        tempIns.add(c2);

        session.save(c1);
        session.save(c2);

    }

    public static void getCourses(Session session) {
        int id = 4;
        Instructor tempIns =  session.get(Instructor.class, id);

        System.out.println("Instructor: " + tempIns);
        System.out.println("Courses:" + tempIns.getCourses());

    }

    public static void deleteCourse(Session session) {

        int id=10;
        Course c1 = session.get(Course.class, id);
        session.delete(c1);
        System.out.println("Courses Deleted...." + c1);

    }

    public static void queryData(Session session) {
        Query<Instructor> query =
                session.createQuery("select i from Instructor i "
                        + "JOIN FETCH i.courses " +
                        "where i.id=:theInstructorId",
                Instructor.class);
        query.setParameter("theInstructorId", 4);
        Instructor tempIns = query.getSingleResult();

        System.out.println("Instructor: " + tempIns);
    }

    public static void addCourseAndReview(Session session) {
        System.out.println("Creating course....");
        Course c1 = new Course("How to win a fight");

        System.out.println("Adding reviews...");
        c1.addReview(new Review("Great course"));
        c1.addReview(new Review("Very Effective"));
        c1.addReview(new Review("Helped me in many ways"));

        System.out.println("Saving reviews");
        session.save(c1);
    }

    public static void deleteCourseAndReview(Session session) {
        int id = 13;
        Course c1 = session.get(Course.class, id);
        System.out.println("Deleting the course..." + c1);
        session.delete(c1);
        System.out.println("Course Deleted....");
    }

    public static void addCourseAndStudent(Session session) {
        Course c1 = session.get(Course.class, 14);

        Student tempS1 = new Student("John Doe", "John@email.com");
        Student tempS2 = new Student("Mary Jane", "Marry@email.com");

        c1.addStudent(tempS1);
        c1.addStudent(tempS2);

        session.save(tempS1);
        session.save(tempS2);
    }

    public static void addCourseToStudent(Session session) {
        System.out.println("Adding courses to student....");
        Student tempS = session.get(Student.class, 2);

        Course c1 = new Course("How to be a villain");
        Course c2 = new Course("How to defeat a hero");

        c1.addStudent(tempS);
        c2.addStudent(tempS);

        session.save(c1);
        session.save(c2);
    }


    public static void getCourseAndStudent(Session session) {
        System.out.println("Getting Student And Courses....");

        Student tempS = session.get(Student.class, 2);

        System.out.println("Student: " + tempS);
        System.out.println("Courses: " + tempS.getCourses());

    }


}
