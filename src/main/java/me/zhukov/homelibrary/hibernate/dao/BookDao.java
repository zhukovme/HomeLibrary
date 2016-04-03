package me.zhukov.homelibrary.hibernate.dao;

import me.zhukov.homelibrary.hibernate.data.Book;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Michael Zhukov
 */
public class BookDao implements Dao<Book> {

    private Session session;

    public BookDao(Session session) {
        this.session = session;
    }

    public long insert(Book entity) {
        return (Long) session.save(entity);
    }

    public void update(Book entity) {
        session.update(entity);
    }

    public void delete(Book entity) {
        session.delete(entity);
    }

    public void deleteAll() {
        session.createSQLQuery("truncate table book").executeUpdate();
    }

    public Book findById(long id) {
        return session.get(Book.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        return session.createCriteria(Book.class).list();
    }
}
