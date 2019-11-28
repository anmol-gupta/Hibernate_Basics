package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		//create session 
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List <Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			students = session.createQuery("from Student s where s.lastName = 'sharma'").getResultList();
			displayStudents(students);
			students = session.createQuery("from Student s where s.lastName = 'sharma'" 
			+ "AND s.firstName = 'setu'").getResultList();
			System.out.println("List of students with last name is sharma and dirst name is setu");
			displayStudents(students);
			session.getTransaction().commit();
			System.out.println("Done!!");
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for(Student item: students) {
			System.out.println(item);
		}
	}

}
