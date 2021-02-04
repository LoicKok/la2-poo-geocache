package org.ig2i.la2;

import geocache.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class Main {

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate/hibernate.cfg.xml");

            SessionFactory ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void main(String[] args) {

    }
}
