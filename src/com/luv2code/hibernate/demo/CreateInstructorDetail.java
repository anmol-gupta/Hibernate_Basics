package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDetail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		Instructor tempInstructor = new Instructor("Dumpy", "Gupta", "anmolify@gmail.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/dumpify", "Editing");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		session.beginTransaction();
		session.save(tempInstructor);
		session.getTransaction().commit();
	}

}
