package com.awesome;

import com.awesome.entity.Course;
import com.awesome.entity.Customer;
import com.awesome.entity.Orders;
import com.awesome.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class HbnTest {
    @Test
    public void test01() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Customer customer = new Customer();
        customer.setName("Buffet");

        Orders orders = new Orders();
        orders.setDescription("Pork");
        orders.setCustomer(customer);
        session.save(customer);
        session.save(orders);
        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Course course = new Course();
        course.setTitle("JAVA");
        Student student = new Student();
        student.setName("Tomcat");

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        student.setCourses(courses);

        session.save(course);
        session.save(student);

        session.beginTransaction().commit();
        session.close();
    }
}
