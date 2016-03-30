package dbService.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @author Michael Zhukov
 */
public abstract class Dao<T extends Serializable> {

    private Session session;

    public Dao(Session session) {
        this.session = session;
    }

    void insert(T entity) {
        session.save(entity);
    }

    void update(T entity) {
        session.saveOrUpdate(entity);
    }

    void delete(T entity) {
        session.delete(entity);
    }

    void deleteAll() {
        for (T entity : findAll()) {
            session.delete(entity);
        }
    }

    abstract T findById(long id);

    abstract List<T> findAll();
}
