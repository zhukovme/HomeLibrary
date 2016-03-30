package me.zhukov.homelibrary.hibernate.services;

import me.zhukov.homelibrary.Callable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author Michael Zhukov
 */
public class SessionService {

    private final SessionFactory sessionFactory;

    public SessionService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void doWorkInSession(Callable callable) {
        Session session = sessionFactory.openSession();
        callable.doWork(session);
        session.close();
    }

    public void doWorkInTransaction(Callable callable) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        callable.doWork(session);
        transaction.commit();
        session.close();
    }
}
