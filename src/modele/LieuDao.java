package modele;

import geocache.LieuEntity;
import geocache.UserEntity;
import utils.JpaDao;

public class LieuDao extends JpaDao<LieuEntity> implements DAOInterface{

    private static LieuDao instance;

    public LieuDao() {
        super(LieuEntity.class);
    }

    public static LieuDao getInstance(){
        if(instance == null) {
            instance = new LieuDao();
        }
        return instance;
    }



}
