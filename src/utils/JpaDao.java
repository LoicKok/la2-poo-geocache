package utils;

import modele.DAOInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public abstract class JpaDao<T> implements DAOInterface {
private SessionFactory ourSessionFactory;
private Session session;
protected EntityManager em;
private Class<T> entityClass;



    public JpaDao(Class<T> entityClass){
        try {
            this.entityClass = entityClass;
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.out.println(ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void openSession(){
        session = ourSessionFactory.openSession();
        em = session.getEntityManagerFactory().createEntityManager();
    }


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
            System.out.println("Entity " + obj.getClass().getName() + " deleted successfully");
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
    public T read(Integer id) {
        return em.find(this.entityClass, id);
    }

}