//package com.example.ss;
//
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class StudentController {
//
//    List<Student> stud = new ArrayList<>();
//
//    @GetMapping("/student")
//    public List<Student> getStudents() {
//
//        stud.add(new Student(2, "Jack", true));
//        stud.add(new Student(4, "Susane" ,false));
//        stud.add(new Student(6, "Neha", false));
//        stud.add(new Student(9, "amana", true));
//
//        return stud;
//    }
//
//    @GetMapping("/student/{id}")
//    public Student getStudent(@PathVariable int id) {
//        if (id >= stud.size() || id < 0) {
//            throw new StudentNotFoundException("Student with id " + id + "not found");
//        }
//        return stud.get(id);
//    }
//
//}