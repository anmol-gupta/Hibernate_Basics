package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		try { 
			//start a transaction 
			session.beginTransaction();
			int studentId = 8;
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = session.get(Student.class, studentId);
			session.delete(myStudent);
			//commit the transaction 
			session.getTransaction().commit();
			
			//new code to update the domain of email for student with id 2
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=2").executeUpdate();
			System.out.println("Done!!");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}

}
