package com.awesome;

import com.awesome.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class HbnTest {
    @Test
    public void test01() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Person tom = new Person(null, "Tom", 2000.0);
        session.save(tom);
        session.beginTransaction().commit();
        session.close();
    }
}
