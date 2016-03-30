package me.zhukov.homelibrary;

import org.hibernate.Session;

/**
 * @author Michael Zhukov
 */
public interface Callable {

    void doWork(Session session);
}
