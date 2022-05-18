package com.awesome;

import com.awesome.entity.Customer;
import com.awesome.entity.Orders;
import com.awesome.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

public class HbnTest {
    @Test
    public void test01() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from Person where name like '%m%'";
        Query query = session.createQuery(hql);
        List<Person> people = query.list();

        for (Person person : people) {
            System.out.println(person);
        }

        session.close();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from Person where name like '%m%' order by id";
        Query query = session.createQuery(hql);
        List<Person> people = query.list();

        for (Person person : people) {
            System.out.println(person);
        }

        session.close();
    }

    @Test
    public void test03() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from Person where name like '%m%' order by id desc";
        Query query = session.createQuery(hql);
        List<Person> people = query.list();

        for (Person person : people) {
            System.out.println(person);
        }

        session.close();
    }

    @Test
    public void test04() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "select name from Person where id=3";
        Query query = session.createQuery(hql);
        String name = (String) query.uniqueResult();
        System.out.println(name);

        session.close();
    }

    @Test
    public void test05() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from Person where name=:name";
        Query query = session.createQuery(hql);
        query.setString("name", "Tom");
        List<Person> people = query.list();

        for (Person person : people) {
            System.out.println(person);
        }

        session.close();
    }

    @Test
    public void test06() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql1 = "from Customer where name=:name";
        Query query1 = session.createQuery(hql1);
        query1.setString("name", "Lora");
        Customer customer = (Customer) query1.uniqueResult();

        String hql2 = "from Orders where customer=:customer";
        Query query2 = session.createQuery(hql2);
        query2.setEntity("customer", customer);
        List<Orders> orders = query2.list();

        for (Orders order : orders) {
            System.out.println(order);
        }

        session.close();
    }
}
