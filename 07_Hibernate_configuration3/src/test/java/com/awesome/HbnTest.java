package com.awesome;

import com.awesome.entity.Customer;
import com.awesome.entity.Orders;
import com.awesome.entity.Person;
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
        customer.setName("Nancy");

        Orders orders1 = new Orders();
        orders1.setDescription("Beef");
        orders1.setCustomer(customer);

        Orders orders2 = new Orders();
        orders2.setDescription("Meet");
        orders2.setCustomer(customer);

        HashSet<Orders> orders = new HashSet<>();
        orders.add(orders1);
        orders.add(orders2);
        customer.setOrders(orders);

        session.save(customer);
        session.save(orders1);
        session.save(orders2);

        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, 14);

//        Set<Orders> orders = customer.getOrders();
//
//        for (Orders order : orders) {
//            session.delete(order);
//        }

        session.delete(customer);
        session.beginTransaction().commit();
        session.close();
    }
}
