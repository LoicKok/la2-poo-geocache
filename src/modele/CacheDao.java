package modele;

import geocache.CacheEntity;
import geocache.UserEntity;

import utils.JpaDao;

import javax.persistence.Query;
import java.util.List;


public class CacheDao extends JpaDao<CacheEntity> implements DAOInterface{

    private static CacheDao instance;

    public CacheDao() {
        super(CacheEntity.class);
    }


    public static CacheDao getInstance(){
        if(instance == null) {
            instance = new CacheDao();
        }
        return instance;
    }

    public static List getListFiltre(UserEntity user){
        Query query = instance.em.createNamedQuery("listVisiteFiltre",CacheEntity.class);
        query.setParameter("proprietaire", user);

        return query.getResultList();
    }



}
