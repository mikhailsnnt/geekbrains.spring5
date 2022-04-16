package ru.geekbrains.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static Session getCurrentSession() {
        Session session = sessionFactory.getCurrentSession();
        if(session.isOpen())
            return session;
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory(){
        sessionFactory.close();
    }
}
