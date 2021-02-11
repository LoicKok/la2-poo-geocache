package modele;

import geocache.UserEntity;
import utils.JpaDao;

public class UserDao extends JpaDao<UserEntity> implements DAOInterface{

    private static UserDao instance;

    public static UserDao getInstance(){
        if(instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    @Override
    public void create(Object user) {
        super.create(user);
    }

    @Override
    public UserEntity read(Integer id) {
        return super.read(id);
    }

    @Override
    public void update(Object user) {
        super.update(user);
    }

    @Override
    public void delete(Object user) {
        super.delete(user);
    }
}
