package com.awesome;

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
        Person person = new Person();
        person.setName("Snach");
        session.save(person);
        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Person person = session.get(Person.class, 4);
        person.setName("Bill");
        session.update(person);
        session.beginTransaction().commit();
        session.close();
    }

    @Test
    public void test03() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        String hql = "from Person";
        Query query = session.createQuery(hql);
        List<Person> people = query.list();

        for (Person person : people) {
            System.out.println(person);
        }
        session.beginTransaction().commit();
        session.close();
    }
}
