package me.zhukov.homelibrary.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Michael Zhukov
 */
public interface Dao<T extends Serializable> {

    long insert(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();

    T findById(long id);

    List<T> findAll();
}
