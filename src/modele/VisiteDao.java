package modele;

import geocache.VisiteEntity;
import utils.JpaDao;

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



}
