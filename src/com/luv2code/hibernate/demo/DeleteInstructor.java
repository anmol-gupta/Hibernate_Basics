package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int theId = 2;
		Instructor tempInstructor = session.get(Instructor.class, theId);
		if (tempInstructor!=null) {
			session.delete(tempInstructor);
		}
		else
			System.out.println("No instructor found with this id.");
		session.getTransaction().commit();
	}

}
