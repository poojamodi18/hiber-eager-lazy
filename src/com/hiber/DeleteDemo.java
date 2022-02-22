package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiber.entity.Instructor;
import com.hiber.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			int id = 5;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
			
			if(instructorDetail!=null) {
				System.out.println("Found and deleted");
				instructorDetail.getInstructor().setInstructorDetailId(null);
				session.delete(instructorDetail);
			}
			else {
				System.out.println("Not found");
			}
			
			session.getTransaction().commit();

		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
