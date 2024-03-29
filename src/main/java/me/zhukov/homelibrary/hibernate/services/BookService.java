package me.zhukov.homelibrary.hibernate.services;

import me.zhukov.homelibrary.hibernate.dao.BookDao;
import me.zhukov.homelibrary.hibernate.data.Book;
import me.zhukov.homelibrary.hibernate.work.ReturningWork;
import me.zhukov.homelibrary.hibernate.work.Work;
import org.hibernate.Session;

import java.util.List;

/**
 * @author Michael Zhukov
 */
public class BookService extends DBService {

    private final SessionService sessionService;

    public BookService() {
        super();
        sessionService = new SessionService(sessionFactory);
    }

    public long addBook(final Book book) {
        return sessionService.doWorkInTransaction(session -> {
            BookDao dao = new BookDao(session);
            return dao.insert(book);
        });
    }

    public Book getBook(final long id) {
        return sessionService.doWorkInSession(session -> {
            BookDao dao = new BookDao(session);
            return dao.findById(id);
        });
    }

    public List<Book> getAllBooks() {
        return sessionService.doWorkInSession(session -> {
            BookDao dao = new BookDao(session);
            return dao.findAll();
        });
    }

    public void updateBook(final Book book) {
        sessionService.doWorkInTransaction(session -> {
            BookDao dao = new BookDao(session);
            dao.update(book);
        });
    }

    public void deleteBook(final Book book) {
        sessionService.doWorkInTransaction(session -> {
            BookDao dao = new BookDao(session);
            dao.update(book);
        });
    }

    public void deleteAllBooks() {
        sessionService.doWorkInTransaction(session -> {
            BookDao dao = new BookDao(session);
            dao.deleteAll();
        });
    }
}
