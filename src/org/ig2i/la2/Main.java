package org.ig2i.la2;

import geocache.CacheEntity;
import geocache.LieuEntity;
import geocache.UserEntity;
import geocache.VisiteEntity;
import modele.CacheDao;
import modele.LieuDao;
import modele.UserDao;
import modele.VisiteDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            SessionFactory ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {


        UserDao u1 = UserDao.getInstance();
        u1.openSession();
        UserEntity user = u1.read(1);
        System.out.println(user.toString());

        LieuDao l1 = LieuDao.getInstance();
        l1.openSession();
        LieuEntity lieu = l1.read(1);
        System.out.println(lieu.toString());


        CacheDao c1 = CacheDao.getInstance();
        c1.openSession();
        CacheEntity cache = c1.read(1);
        System.out.println(cache.toString());

        VisiteDao v1 = VisiteDao.getInstance();
        v1.openSession();
        VisiteEntity visite = v1.read(1);
        System.out.println(visite.toString());
    }
}
