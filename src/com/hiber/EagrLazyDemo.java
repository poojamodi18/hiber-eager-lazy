package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Course;
import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class EagrLazyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);
			

			if (instructor != null) {

				System.out.println(instructor.toString());
				
				System.out.println("Courses");
				System.out.println(instructor.getCourses());
				
			} else {
				System.out.println("Instrctor not found");
			}

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
