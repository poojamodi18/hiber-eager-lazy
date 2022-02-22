package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Course;
import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			Instructor instructor = new Instructor("Namjoon","Kim","mono@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/bangtantv", "reading");
			
			instructor.setInstructorDetailId(instructorDetail);
			
			session.beginTransaction();
			
			session.save(instructor);
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
