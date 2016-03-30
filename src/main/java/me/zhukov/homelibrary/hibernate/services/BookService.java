package me.zhukov.homelibrary.hibernate.services;

import me.zhukov.homelibrary.Callable;
import me.zhukov.homelibrary.hibernate.dao.BookDao;
import me.zhukov.homelibrary.hibernate.data.Book;
import org.hibernate.Session;

/**
 * @author Michael Zhukov
 */
public class BookService extends DBService {

    private final SessionService sessionService;

    public BookService() {
        sessionService = new SessionService(sessionFactory);
    }

    public long addBook(final Book book) {
        sessionService.doWorkInTransaction(new Callable() {
            public void doWork(Session session) {
                BookDao dao = new BookDao(session);
                long id = dao.insert(book);
            }
        });
        return 0; // fixme сделать норм "callable"
    }

    public Book getBook(final long id) {
        sessionService.doWorkInSession(new Callable() {
            public void doWork(Session session) {
                BookDao dao = new BookDao(session);
                Book book = dao.findById(id);
            }
        });
        return null;  // fixme сделать норм "callable"
    }

    public void updateBook(final Book book) {
        sessionService.doWorkInTransaction(new Callable() {
            public void doWork(Session session) {
                BookDao dao = new BookDao(session);
                dao.update(book);  // fixme сделать норм "callable"
            }
        });
    }

    public void deleteBook(final Book book) {
        sessionService.doWorkInTransaction(new Callable() {
            public void doWork(Session session) {
                BookDao dao = new BookDao(session);
                dao.update(book);  // fixme сделать норм "callable"
            }
        });
    }
}
