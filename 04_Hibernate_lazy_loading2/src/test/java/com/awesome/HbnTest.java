package com.awesome;

import com.awesome.entity.Course;
import com.awesome.entity.Customer;
import com.awesome.entity.Orders;
import com.awesome.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Set;

public class HbnTest {
    @Test
    public void test01() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Orders orders = session.get(Orders.class, 1);
        System.out.println(orders);
        session.close();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 1);
        System.out.println(course.getStudents());
        session.close();
    }

    @Test
    public void test03() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, 1);
        System.out.println(student.getCourses());
        session.close();
    }
}
