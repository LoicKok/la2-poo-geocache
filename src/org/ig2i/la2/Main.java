package org.ig2i.la2;

import geocache.UserEntity;
import modele.UserDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

        UserEntity u1 = new UserEntity();
        UserDao.getInstance().read(1);
    }
}
