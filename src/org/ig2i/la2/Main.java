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

import java.util.List;

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
        System.out.println("User -> read :");
        System.out.println(user.toString());

        UserEntity userRead = u1.read(57);

        if(userRead != null){
            u1.delete(userRead);
        }

        UserEntity user2 = new UserEntity(57);
        u1.create(user2);

        System.out.println(u1.read(57));

        user2.setPseudo("Bernard");
        u1.update(user2);

        System.out.println(u1.read(57));
        LieuDao l1 = LieuDao.getInstance();

        l1.openSession();
        LieuEntity lieu = l1.read(1);
        System.out.println(lieu.toString());

        CacheDao c1 = CacheDao.getInstance();
        c1.openSession();
        System.out.println("getAllCacheOfUser :");
        System.out.println(c1.getAllCacheByUser(user));
        System.out.println("\ngetALLCacheFromPlace :");
        System.out.println(c1.getALLCacheByPlace(lieu));
        CacheEntity cache = c1.read(1);
        System.out.println(cache.toString());

        VisiteDao v1 = VisiteDao.getInstance();
        v1.openSession();

        VisiteEntity visite = v1.read(2);
        System.out.println(visite.toString());

        System.out.println("Liste visites par utilisateur (loic) :");
        System.out.println(v1.getVisiteByUser(user));



    }

}
