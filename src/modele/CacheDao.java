package modele;

import geocache.CacheEntity;
import utils.JpaDao;

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



}
