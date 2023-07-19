package app.DAO;

import java.util.LinkedList;
import java.util.List;

public class DAOLinkedList<T extends Identifable> implements DAO<T> {

    int cur = 0;
    private final List<T> storage = new LinkedList<>() {
    };


    @Override
    public void save(T obj) {
        storage.add(obj);
    }

    @Override
    public int daoSize() {
        return storage.size();
    }

    @Override
    public boolean delete(T obj) {
        if (storage.contains(obj)) {
            storage.remove(obj);
            return true;
        }
        return false;

    }

    @Override
    public void saveAll(List<T> entities) {
        storage.addAll(entities);

    }

    @Override
    public List<T> findAll() {
        return storage;
    }

    @Override
    public boolean deleteById(int id) {
        if (storage.get(id) != null) {
            storage.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public T getOne(int id) {
        return storage.get(id);
    }
}
