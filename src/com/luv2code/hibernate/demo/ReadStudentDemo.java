package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		try {
			//create a student object
			System.out.println("creating a new student object.....");
			Student tempStudent = new Student("Mamta","Gupta","mamta@gmail.com"); 
			//start a transaction 
			session.beginTransaction();
			//save the student object
			System.out.println("Saving tempStudent to the database");
			session.save(tempStudent);
			//commit transaction 
			session.getTransaction().commit();
		
			
			//new code for reading the object
			
			//get a new session and start a transaction 
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Got complete: " + myStudent);
			//commit the transaction 
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			factory.close();
		}
	}

}
