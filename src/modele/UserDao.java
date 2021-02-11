package modele;

import geocache.UserEntity;
import utils.JpaDao;

public class UserDao extends JpaDao<UserEntity> implements DAOInterface{

    private static UserDao instance;

    public UserDao() {
        super(UserEntity.class);
    }

    public static UserDao getInstance(){
        if(instance == null) {
            instance = new UserDao();
        }
        return instance;
    }



}
