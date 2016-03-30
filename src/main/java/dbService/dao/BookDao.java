package dbService.dao;

import dbService.data.Book;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Michael Zhukov
 */
public class BookDao extends Dao<Book> {

    private Session session;

    public BookDao(Session session) {
        super(session);
        this.session = session;
    }

    public Book findById(long id) {
        return session.get(Book.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        return session.createCriteria(Book.class).list();
    }
}
