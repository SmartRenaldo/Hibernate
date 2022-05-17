package com.awesome;

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
        String hql = "from Person";
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

        String hql = "from Person";
        Query query = session.createQuery(hql);
        query.setFirstResult(2);
        query.setMaxResults(3);
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

        String hql = "from Person where id=4";
        Query query = session.createQuery(hql);
        Person person = (Person) query.list().get(0);

        System.out.println(person);

        session.close();
    }

    @Test
    public void test04() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "from Person where id=4 and money=null";
        Query query = session.createQuery(hql);
        Person person = (Person) query.uniqueResult();

        System.out.println(person);

        session.close();
    }
}
