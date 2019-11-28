package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		try {
			//create a student object
			System.out.println("creating a new student object.....");
			Student tempStudent1 = new Student("Ankit","Gupta","imankit@gmail.com");
			Student tempStudent2 = new Student("Ayushi","Gupta","ayushi@gmail.com");
			Student tempStudent3 = new Student("Juhi","Gupta","juhi@gmail.com");
			//start a transaction 
			session.beginTransaction();
			//save the student object
			System.out.println("Saving tempStudent to the database");
			session.save(tempStudent1);
			session.save(tempStudent3);
			session.save(tempStudent2);
			//commit transaction 
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			factory.close();
		}
	}

}
