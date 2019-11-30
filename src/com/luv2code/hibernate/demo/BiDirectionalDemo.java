package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class BiDirectionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		int theId = 2;
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
		System.out.println("Instructor Detail with the required id ->" + tempInstructorDetail);
		System.out.println("Instructor with the required id ->" + tempInstructorDetail.getInstructor());
		session.getTransaction().commit();
	}

}
