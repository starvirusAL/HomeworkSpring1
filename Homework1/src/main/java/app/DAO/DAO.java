package app.DAO;

import java.util.List;

public interface DAO<T> {


    void save(T obj);

    boolean delete(T obj);
    void saveAll(List<T> entities);
    List<T> findAll();
    boolean deleteById(int id);
    int daoSize();


    T getOne(int id);
}
