package modele;


public interface DAOInterface<T>{

    void create(T obj);

    T read(Integer id);

    void update(T obj);

    void delete(T obj);

}
