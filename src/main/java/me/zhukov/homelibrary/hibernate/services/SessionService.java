package me.zhukov.homelibrary.hibernate.services;

import me.zhukov.homelibrary.hibernate.work.ReturningWork;
import me.zhukov.homelibrary.hibernate.work.Work;
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

    public <T> T doWorkInSession(ReturningWork<T> work) {
        Session session = sessionFactory.openSession();
        T result = work.doWork(session);
        session.close();
        return result;
    }

    public void doWorkInSession(Work work) {
        Session session = sessionFactory.openSession();
        work.doWork(session);
        session.close();
    }

    public <T> T doWorkInTransaction(ReturningWork<T> work) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T result = work.doWork(session);
        transaction.commit();
        session.close();
        return result;
    }

    public void doWorkInTransaction(Work work) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        work.doWork(session);
        transaction.commit();
        session.close();
    }
}
