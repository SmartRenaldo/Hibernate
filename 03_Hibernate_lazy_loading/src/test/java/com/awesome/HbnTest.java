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
        Customer customer = session.get(Customer.class, 7);
        Set<Orders> orders = customer.getOrders();
//        System.out.println(customer);
        System.out.println(orders.size());
        session.close();
    }
}
