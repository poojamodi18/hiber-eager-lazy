package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Course;
import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 1;
			Instructor instructor = session.get(Instructor.class, id);

			if (instructor != null) {
				Course course1 = new Course("Music Composing");
				Course course2 = new Course("Lyrics Writing");

				instructor.add(course1);
				instructor.add(course2);

				session.save(course1);
				session.save(course2);
			}else {
				System.out.println("Instrctor not found");
			}

			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
