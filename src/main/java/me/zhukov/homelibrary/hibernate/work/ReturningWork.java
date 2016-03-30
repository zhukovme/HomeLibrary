package me.zhukov.homelibrary.hibernate.work;

import org.hibernate.Session;

/**
 * @author Michael Zhukov
 */
public interface ReturningWork<T> {

    T doWork(Session session);
}
