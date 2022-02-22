package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class InstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 3;
			
			InstructorDetail detail = session.get(InstructorDetail.class, id);
			
			
			if(detail!=null) {
				System.out.println("Found");
				System.out.println(detail.toString());
				System.out.println(detail.getInstructor().toString());
			}
			
			
			session.getTransaction().commit();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
