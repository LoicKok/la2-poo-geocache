package utils;

import modele.DAOInterface;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JpaDao<U> implements DAOInterface {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JaimeLaPOO");
    EntityManager em = emf.createEntityManager();

    public void create(Object obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
            System.out.println("Entity " + obj.getClass().getName() + " persisted successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void delete(Object obj) {
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
            System.out.println("Entity " + obj.getClass().getName() + " persisted successfully");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void update(Object obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
            System.out.println("Success");
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    public Object read(Integer id) {
        return em.find(Object.class, id);
    }

}