package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Course;
import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class DeleteCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 10;
			
			Course course = session.get(Course.class, id);
			
			if(course!=null) {
				session.delete(course);
			}
			else {
				System.out.println("Course not found");
			}

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
