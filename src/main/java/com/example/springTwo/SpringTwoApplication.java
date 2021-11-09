package com.example.springTwo;


//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;


//@SpringBootApplication
public class SpringTwoApplication {

	public static void main(String[] args) {
		System.out.println("Application started");
//		SpringApplication.run(SpringTwoApplication.class, args);

		String url = "jdbc:mysql://localhost:3306/hb_student?useSSL=false";

		try {
			System.out.println("Connecting to database");
			Connection myConn =
					DriverManager.getConnection(url, "hbstudent", "hbstudent");

			System.out.println("Connection Successsful!!!");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
