package modele;

import geocache.CacheEntity;
import geocache.LieuEntity;
import geocache.UserEntity;
import geocache.VisiteEntity;
import utils.JpaDao;

import javax.persistence.Query;
import java.util.List;

public class VisiteDao extends JpaDao<VisiteEntity> implements DAOInterface{

    private static VisiteDao instance;

    public VisiteDao() {
        super(VisiteEntity.class);
    }

    public static VisiteDao getInstance(){
        if(instance == null) {
            instance = new VisiteDao();
        }
        return instance;
    }

    public static List<VisiteEntity> getVisiteByUser(UserEntity user){
        Query query = instance.em.createNamedQuery("listVisiteByUser",VisiteEntity.class);
        query.setParameter("user", user);

        return query.getResultList();
    }



}
