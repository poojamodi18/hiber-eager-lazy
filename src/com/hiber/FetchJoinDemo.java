package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hiber.entity.Course;
import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int id = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theId", Instructor.class);
			query.setParameter("theId", id);
			
			Instructor instructor = query.getSingleResult();
			
			System.out.println(instructor);
			
//			System.out.println(instructor.getCourses().toString());
			
			System.out.println(instructor.getCourses());
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}
	}

}
